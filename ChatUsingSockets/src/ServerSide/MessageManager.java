package src.ServerSide;

import src.Shared.SharedObjects.Message;
import src.Shared.Util.Subject;

import java.util.List;

public interface MessageManager extends Subject
{
  Message newMessage(Message arg);
  List<Message> getMessage();
  void setnumberofclients(int smt);
  String getNumberofClients();
  void addClient();
  void removeClient();
}
