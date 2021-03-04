package src.ServerSide.Network;

import src.ServerSide.MessageManager;
import src.Shared.Network.ClientCallback;
import src.Shared.Network.RMIServer;
import src.Shared.SharedObjects.Message;

import java.beans.PropertyChangeListener;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class RMIServerImpl implements RMIServer
{

  private final MessageManager messageManager;

  public RMIServerImpl (MessageManager messageManager) throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
    this.messageManager = messageManager;
  }

  public void startServer() throws RemoteException, AlreadyBoundException
  {
    Registry registry = LocateRegistry.createRegistry(1099);
    registry.bind("ChatServer", this);
  }

  @Override public Message newMessage(Message arg)
  {
    return messageManager.newMessage(arg);
  }

  @Override public List<Message> getMessage()
  {
    return messageManager.getMessage();
  }

  @Override public void setnumberofclients(int smt)
  {
    messageManager.setnumberofclients(smt);
  }

  @Override public String getNumberofClients()
  {
    return messageManager.getNumberofClients();
  }

  @Override public void addClient()
  {
    messageManager.addClient();
  }

  @Override public void removeClient()
  {
    messageManager.removeClient();
  }

  @Override public void registerClient(ClientCallback client)
  {
    PropertyChangeListener listener = null;
    PropertyChangeListener finalListener = listener;

    listener = evt -> {
      try {
        client.update((Message) evt.getNewValue());
      }
      catch (RemoteException e){
        messageManager.removeListener("NewMsgEntry", finalListener);
      }
    };
    messageManager.addListener("NewMsgEntry", listener);
  }
}
