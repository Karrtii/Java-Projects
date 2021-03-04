package ProducerConsumerAdapter;

import Flyweight.Valuable;
import ReadersWritersProxy.Guardsman;
import ReadersWritersProxy.TreaureRoomDoor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ValuableTransporter implements Runnable
{
  private List<Valuable> bag;
  private Buffer deposit;
  private int currentvalue;
  private String personType;
  private TreaureRoomDoor treaureRoomDoor;

  public ValuableTransporter(Buffer deposit, Guardsman guardsman)
  {
    treaureRoomDoor = guardsman;
    personType = "ValuableTransporter";
    this.deposit = deposit;
    this.currentvalue = 0;
    bag = new ArrayList<>();
  }

  @Override public void run()
  {
    while(true)
    {
      int randomnum = (int)(Math.random()*(200 - 50) + 50);
      bag.add((Valuable) deposit.take());
      currentvalue += bag.get(bag.size() - 1).getValue();
      if (randomnum <= currentvalue)
      {

        currentvalue = 0;
        if (bag.size() > 0)
        {
          onway(4000, 5000);
          treaureRoomDoor.acquireWrite();
          treaureRoomDoor.addValuables(personType,bag);
          treaureRoomDoor.releaseWrite();
          bag.clear();
        }
      }
      onway(4000, 6000);
    }
  }

  private void onway(int maxtime,int mintime)
  {
    int time = (int) (Math.random()*(maxtime-mintime) + mintime);
    try
    {
      Thread.sleep(time);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
}
