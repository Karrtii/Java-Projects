package src.ClientSide.Core;

import src.ClientSide.Network.Client;
import src.ClientSide.Network.RMIClient;

public class ClientFactory
{
  private Client client;

  public Client getClient()
  {
    if(client==null)
    {
      client = new RMIClient();
    }
    return client;
  }
}
