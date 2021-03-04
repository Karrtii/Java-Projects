package src.Shared.Network;

import src.Shared.SharedObjects.Message;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface RMIServer extends Remote
{
  Message newMessage(Message arg) throws RemoteException;
  List<Message> getMessage() throws RemoteException;
  void setnumberofclients(int smt) throws RemoteException;
  String getNumberofClients() throws RemoteException;
  void addClient() throws RemoteException;
  void registerClient(ClientCallback client) throws RemoteException;
  void removeClient() throws RemoteException;
}
