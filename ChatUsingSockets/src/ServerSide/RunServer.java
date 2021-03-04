package src.ServerSide;

import java.io.IOException;

public class RunServer
{
  public static void main(String[] args) throws IOException
  {
      SocketServer socketServer = new SocketServer(new MessageManagerImplementation());
      socketServer.startServer();
  }
}
