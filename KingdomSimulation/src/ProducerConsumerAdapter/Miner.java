package ProducerConsumerAdapter;

import Flyweight.Mine;
import Flyweight.Valuable;

import java.util.ArrayList;
import java.util.Random;

public class Miner implements Runnable
{
  private Buffer deposit;
  private ArrayList<String> names;
  private Valuable valuable;

  public Miner(Buffer buffer)
  {
    this.deposit = buffer;
    names = new ArrayList<>();
    names.add("Flyweight.Diamond");
    names.add("Flyweight.GoldNugget");
    names.add("Flyweight.WoodenCoin");
    names.add("Flyweight.Ruby");
    names.add("Flyweight.Jewel");
  }

  @Override public void run()
  {
    while (true)
    {
      Random a = new Random();
      int randomnum = a.nextInt(((4-0)+1)+0);
      valuable = Mine.getValuable(names.get(randomnum));
      deposit.put(valuable);
      put(4000,6000);
    }
  }

  public void put(int min, int max)
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
