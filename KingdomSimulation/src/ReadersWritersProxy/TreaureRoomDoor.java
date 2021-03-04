package ReadersWritersProxy;

import Flyweight.Valuable;

import java.util.List;

public interface TreaureRoomDoor
{
  void addValuables(String persontype, List<Valuable> bag);
  List<Valuable> retrieveValuables(String persontype);
  List lookAtValuables(String persontype);
  Valuable take(String persontype);
  void put(Valuable valuable,String persontype);
  void acquireRead();
  void releaseRead();
  void acquireWrite();
  void releaseWrite();
}
