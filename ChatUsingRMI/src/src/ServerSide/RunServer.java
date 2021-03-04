package src.ServerSide;

import src.ServerSide.Network.RMIServerImpl;

import java.io.IOException;
import java.rmi.AlreadyBoundException;

public class RunServer
{
  public static void main(String[] args)
      throws IOException, AlreadyBoundException
  {
      RMIServerImpl socketServer = new RMIServerImpl(new MessageManagerImplementation());
      socketServer.startServer();
  }
}
