package src.Shared.Network;

import src.Shared.SharedObjects.Message;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientCallback extends Remote
{
  void update (Message entry) throws RemoteException;
}
