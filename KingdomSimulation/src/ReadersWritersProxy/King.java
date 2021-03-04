package ReadersWritersProxy;

import Flyweight.Valuable;
import Singleton.Log;

import java.util.ArrayList;
import java.util.List;

public class King implements Runnable
{
  private String personType;
  private List<Valuable> valuables;
  private TreaureRoomDoor treaureRoomDoor;
  private int totalSum;

  public King(Guardsman guardsman)
  {
    valuables = new ArrayList<>();
    treaureRoomDoor = guardsman;
    this.personType = "King";
  }

  @Override public void run()
  {
    while(true)
    {
      int randomnum = (int)(Math.random()*(200 - 50) + 50);
      treaureRoomDoor.acquireWrite();
      Valuable takenval = treaureRoomDoor.take(personType);
      if(takenval==null)
      {
        try
        {
          if(valuables.size()==0)
          {

          }
          else{
          for (int i = 0; i < valuables.size(); i++)
          {
            treaureRoomDoor.put(valuables.get(i),personType);
          }
          }
          Thread.sleep(5000);
        }
        catch (InterruptedException e)
        {
          e.printStackTrace();
        }
      }
      else
        {
          valuables.add(takenval);
          totalSum += takenval.getValue();

          if(totalSum >= randomnum)
          {
            Log.getInstance().addLog("King throws party"+ " Value:"+totalSum+ " PartyCost: "+randomnum);
            totalSum = 0;
            valuables.clear();
            try
            {
              Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
              e.printStackTrace();
            }
          }
        }



      treaureRoomDoor.releaseWrite();
      try
      {
        Thread.sleep(5000);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }
}
