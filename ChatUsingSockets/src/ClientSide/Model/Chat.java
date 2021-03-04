package src.ClientSide.Model;

import src.Shared.SharedObjects.Message;
import src.Shared.Util.Subject;

import java.util.List;

public interface Chat extends Subject
{
  Message newMessage(String text);
    List<Message> getMessages();
    void setUsername(String username);
    String getNumber();
    void decrementClient();
}
