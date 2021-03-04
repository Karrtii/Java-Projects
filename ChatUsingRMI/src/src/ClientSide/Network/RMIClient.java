package src.ClientSide.Network;

import src.Shared.Network.ClientCallback;
import src.Shared.Network.RMIServer;
import src.Shared.SharedObjects.Message;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class RMIClient implements Client, ClientCallback
{
  private RMIServer server;
  private PropertyChangeSupport support;

  public RMIClient()
  {
    support = new PropertyChangeSupport(this);
  }

  @Override public Message newMessage(Message str)
  {
    try
    {
      return server.newMessage(str);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Could not contact server");
    }
  }

  @Override public List<Message> getMessages()
  {
    try
    {
      return server.getMessage();
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Could not contact server");
    }
  }

  @Override public void startClient()
  {
    try
    {
      UnicastRemoteObject.exportObject(this, 0);
      Registry registry = LocateRegistry.getRegistry("localhost", 1099);
      server = (RMIServer) registry.lookup("ChatServer");
      server.registerClient(this);
    }
    catch (RemoteException | NotBoundException e)
    {
      e.printStackTrace();
    }
  }

  @Override public String getNumber()
  {
    try
    {
      return server.getNumberofClients();
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Could not contact server");
    }
  }

  @Override public void addedClient()
  {
    try
    {
      server.addClient();
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void decrementClient()
  {
    try
    {
      server.removeClient();
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void update(Message entry)
  {
    support.firePropertyChange("NewMsgEntry", null, entry);
  }

  @Override public void addListener(String eventName,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(eventName, listener);
  }

  @Override public void removeListener(String eventName,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(eventName, listener);
  }
}
