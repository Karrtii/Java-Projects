package ReadersWritersProxy;

import Flyweight.Valuable;
import Singleton.Log;

import java.util.ArrayList;
import java.util.List;

public class TreasureRoom implements TreaureRoomDoor
{
  private List<Valuable> valuables;
  private int readers;
  private int writers;

  public TreasureRoom()
  {
    readers = 0;
    writers = 0;
    this.valuables = new ArrayList<>();
  }

  @Override public void addValuables(String persontype, List<Valuable> bag)
  {
      Log.getInstance().addLog(Thread.currentThread().getName()+ " brought valuables");
      valuables.addAll(bag);
      Log.getInstance().addLog(bag.toString());
  }

  @Override public List<Valuable> retrieveValuables(String persontype)
  {
    List<Valuable> copy = new ArrayList<>();
    copy.addAll(valuables);
    valuables.clear();
    Log.getInstance().addLog("Copy passed to king"+copy.toString());
    return copy;
  }

  @Override public List<Valuable> lookAtValuables(String persontype)
  {
    return valuables;
  }

  @Override public Valuable take(String persontype)
  {
    if(valuables.size()==0)
    {
      return null;
    }
    else{
    Valuable returnedValuable = valuables.get(valuables.size()-1);
    valuables.remove(valuables.size()-1);
    Log.getInstance().addLog(Thread.currentThread().getName()+" took valuable "+returnedValuable.getName()+ " with Value: "+returnedValuable.getValue());
    return returnedValuable;
    }
  }

  @Override public void put(Valuable valuable,String persontype)
  {
    Log.getInstance().addLog(Thread.currentThread().getName()+" put valuable back");
    valuables.add(valuable);
  }

  @Override public synchronized void acquireRead()
  {
    while (writers > 0)
    {
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    readers++;
  }

  @Override public synchronized void releaseRead()
  {
    readers--;
    if (readers == 0)
    {
      notify();
    }

  }

  @Override public synchronized void acquireWrite()
  {
    while (readers > 0 || writers > 0)
    {
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }

  @Override public synchronized void releaseWrite()
  {
    writers--;
    notifyAll();
  }
}
