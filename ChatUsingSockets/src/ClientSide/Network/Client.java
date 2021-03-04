package src.ClientSide.Network;

import src.Shared.SharedObjects.Message;
import src.Shared.Util.Subject;

import java.util.List;

public interface Client extends Subject
{
  Message newMessage(Message str);
  List<Message> getMessages();

  void startClient();
  String getNumber();
  void addedClient();
  void decrementClient();
}
