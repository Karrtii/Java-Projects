package src.ServerSide;

import src.Shared.SharedObjects.Message;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class MessageManagerImplementation implements MessageManager
{
private PropertyChangeSupport support;
private List<Message> messageList;
private int numberOfclients;

public MessageManagerImplementation()
{
  this.support=new PropertyChangeSupport(this);
  messageList= new ArrayList<>();
  numberOfclients=0;
}
  @Override public Message newMessage(Message arg)
  {
    Message msg = arg;
    messageList.add(msg);
    support.firePropertyChange("NewMsgEntry", null, msg);
    return msg;
  }

  @Override public List<Message> getMessage()
  {
    return new ArrayList<>(messageList);
  }

  @Override public void setnumberofclients(int smt)
  {
    numberOfclients=smt;
  }

  @Override public String getNumberofClients()
  {
    String a = Integer.toString(numberOfclients);
    return a;
  }

  @Override public void addClient()
  {
    numberOfclients++;
  }

  @Override public void removeClient()
  {
    numberOfclients--;
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
