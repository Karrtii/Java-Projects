package src.ClientSide.Core;

import src.ClientSide.Network.Client;
import src.ClientSide.Network.SocketClient;

public class ClientFactory
{
  private Client client;

  public Client getClient()
  {
    if(client==null)
    {
      client = new SocketClient();
    }
    return client;
  }
}
