package src.ClientSide.Model;

import src.ClientSide.Network.Client;
import src.Shared.SharedObjects.Message;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class ChatManager implements Chat
{
  private PropertyChangeSupport support;
  private Client client;
  private String username;


  public ChatManager(Client client)
  {
    support=new PropertyChangeSupport(this);
    this.client=client;
    client.startClient();
    client.addListener("NewMsgEntry", this::onNewChatEntry);
    client.addedClient();
  }

  private void onNewChatEntry(PropertyChangeEvent propertyChangeEvent)
  {
    support.firePropertyChange(propertyChangeEvent);
  }

  @Override public Message newMessage(String text)
  {

    return client.newMessage(new Message(username,text));
  }

  @Override public List<Message> getMessages()
  {
    return client.getMessages();
  }

  @Override public void setUsername(String username)
  {
    this.username=username;
  }

  @Override public String getNumber()
  {
    return client.getNumber();
  }

  @Override public void decrementClient()
  {
    client.decrementClient();
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
