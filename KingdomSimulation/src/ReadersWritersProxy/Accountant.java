package ReadersWritersProxy;

import Flyweight.Valuable;
import Singleton.Log;

import java.util.List;

public class Accountant implements Runnable
{
  private String personType;
  private TreaureRoomDoor treaureRoomDoor;
  private List<Valuable> listToCount;
  private int value;

  public Accountant(Guardsman guardsman)
  {
    value = 0;
    treaureRoomDoor = guardsman;
    this.personType = "Accountant";
  }

  @Override public void run()
  {
   while (true)
{
  treaureRoomDoor.acquireRead();
  listToCount = treaureRoomDoor.lookAtValuables(personType);
  if(listToCount.size()==0)
  {
    value=0;
  }
  else
  {
    for (int i = 0; i < listToCount.size(); i++)
    {
      value += listToCount.get(i).getValue();
    }
  }
  Log.getInstance().addLog(Thread.currentThread().getName( )+ " looked and counted value: "+value);
  value = 0;
  treaureRoomDoor.releaseRead();
  sleep(2000,5000);
}
  }
  private void sleep(int min,int max)
  {
    int time = (int) (Math.random()*(max-min) + min);
    try
    {
      Thread.sleep(time);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
  }
}
