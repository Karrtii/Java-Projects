package src.ClientSide.Core;


import src.ClientSide.Model.Chat;
import src.ClientSide.Model.ChatManager;

public class ModelFactory
{
  private final ClientFactory cf;
  private Chat chat;

  public ModelFactory(ClientFactory cf){this.cf=cf;}

  public Chat getChat()
  {
    if(chat==null)
      chat=new ChatManager(cf.getClient());
    return chat;
  }
}
