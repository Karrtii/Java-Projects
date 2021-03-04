package src.ClientSide.Network;

import src.Shared.SharedObjects.Message;
import src.Shared.SharedObjects.Request;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class SocketClient implements Client
{
  private PropertyChangeSupport support;
  public SocketClient(){support=new PropertyChangeSupport(this);}

  @Override public Message newMessage(Message str)
  {
    try
    {
      Request response = request(str,"NewMessage");
      return (Message) response.getArg();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    catch (ClassNotFoundException e)
    {
      e.printStackTrace();
    }
    return str;
  }

  @Override public List<Message> getMessages()
  {
    try
    {
      Request response = request(null,"FetchLog");
      return (List<Message>) response.getArg();
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
    return null;
  }
  private Request request(Message arg,String type)
      throws IOException, ClassNotFoundException
  {
    Socket socket = new Socket("localhost", 1234);
    ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
    ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());
    outToServer.writeObject(new Request(type,arg));
    return (Request) inFromServer.readObject();
  }

  public void startClient()
  {
    try
    {
      Socket socket = new Socket("localhost",1234);
      ObjectOutputStream outToServer=new ObjectOutputStream(socket.getOutputStream());
      ObjectInputStream inFromServer=new ObjectInputStream(socket.getInputStream());
      Thread thread = new Thread(()->listenToServer(outToServer,inFromServer));
      thread.setDaemon(true);
      thread.start();
//      new Thread(()-> listenToServer(outToServer,inFromServer)).start();

    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  @Override public String getNumber()
  {
    try
    {
      Request response = request(null,"Number");
      return (String) response.getArg();
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public void addedClient()
  {
    try
    {
      Socket socket = new Socket("localhost", 1234);
      ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
      outToServer.writeObject(new Request("Client",null));
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void decrementClient()
  {
    try
    {
      Socket socket = new Socket("localhost", 1234);
      ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
      outToServer.writeObject(new Request("ClientMinus",null));
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  private void listenToServer(ObjectOutputStream outToServer, ObjectInputStream inFromServer)
  {
    try
    {
      outToServer.writeObject(new Request("Listener", null));
      while(true)
      {
        Request request = (Request) inFromServer.readObject();
        support.firePropertyChange(request.getType(), null, request.getArg());
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    catch (ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void addListener(String eventName,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(eventName,listener);
  }

  @Override public void removeListener(String eventName,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(eventName, listener);
  }
}
