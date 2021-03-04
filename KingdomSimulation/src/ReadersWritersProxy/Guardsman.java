package ReadersWritersProxy;

import Flyweight.Valuable;
import java.util.List;

public class Guardsman implements TreaureRoomDoor
{
  private TreasureRoom treasureRoom;

  public Guardsman()
  {
    this.treasureRoom = new TreasureRoom();
  }

  @Override public void addValuables(String persontype, List<Valuable> bag)
  {
    if(persontype.equals("ValuableTransporter"))
    {
      treasureRoom.addValuables(persontype,bag);
    }
  }

  @Override public List<Valuable> retrieveValuables(String persontype)
  {
    if(persontype.equals("King"))
    {
     return treasureRoom.retrieveValuables(persontype);
    }
    else return null;

  }

  @Override public List<Valuable> lookAtValuables(String persontype)
  {
    if(persontype.equals("Accountant"))
    {
      return treasureRoom.lookAtValuables(persontype);
    }
    else
      {
        System.out.println("Only accountants can look into Treasure room");
        return null;
      }
  }

  @Override public Valuable take(String persontype)
  {
    if(persontype.equals("King"))
    {
      return treasureRoom.take(persontype);
    }
    else return null;

  }

  @Override public void put(Valuable valuable,String persontype)
  {
    treasureRoom.put(valuable,persontype);
  }

  @Override
  public void acquireRead()
  {
    treasureRoom.acquireRead();
  }

  @Override public void releaseRead()
  {
    treasureRoom.releaseRead();
  }

  @Override public void acquireWrite()
  {
    treasureRoom.acquireWrite();
  }

  @Override public void releaseWrite()
  {
    treasureRoom.releaseWrite();
  }
}
