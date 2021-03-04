package src.ServerSide;

import src.Shared.SharedObjects.Message;
import src.Shared.SharedObjects.Request;

import java.beans.PropertyChangeEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class SocketHandler implements Runnable
{
  private Socket socket;
  private MessageManager messageManager;

  private ObjectOutputStream outToClient;
  private ObjectInputStream inFromClient;

  public SocketHandler(Socket socket, MessageManager messageManager)
  {
    this.socket=socket;
    this.messageManager=messageManager;

    try
    {
      outToClient = new ObjectOutputStream(socket.getOutputStream());
      inFromClient=new ObjectInputStream(socket.getInputStream());
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void run()
  {
    try
    {
      Request request = (Request) inFromClient.readObject();
      if("Listener".equals(request.getType()))
      {
        messageManager.addListener("NewMsgEntry", this::inNewLogEntry);
      }
      else if("NewMessage".equals(request.getType()))
      {
        Message result = messageManager.newMessage((Message) request.getArg());
        outToClient.writeObject(new Request("NewMessage",result));
      }
      else if("FetchLog".equals(request.getType()))
      {
        List<Message> log = messageManager.getMessage();
        outToClient.writeObject(new Request("FetchLog", log));
      }
      else if("Number".equals(request.getType()))
      {

        String num = messageManager.getNumberofClients();
        outToClient.writeObject(new Request("Number",num));
      }
      else if("Client".equals(request.getType()))
      {
        messageManager.addClient();
      }
      else if("ClientMinus".equals(request.getType()))
      {
        messageManager.removeClient();
      }
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }

  private void inNewLogEntry(PropertyChangeEvent propertyChangeEvent)
  {
    try
    {
      outToClient.writeObject(new Request(propertyChangeEvent.getPropertyName(), propertyChangeEvent.getNewValue()));
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
