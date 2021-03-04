package ProducerConsumerAdapter;

import Singleton.Log;

public class Deposit implements Buffer
{
  private ArrayList arrayList;
  private int capacity;
  public Deposit(int capacity)
  {
    this.capacity = capacity;
    this.arrayList = new ArrayList();
  }

  @Override public synchronized void put(Object element)
  {
    while(arrayList.size() >= capacity)
    {
      try
      {
        wait();
        //Log.getInstance().addLog(Thread.currentThread().getName()+" is waiting");
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    //Log.getInstance().addLog(Thread.currentThread().getName()+" is working" + toString());
    arrayList.add(element);
    notifyAll();
  }

  @Override public synchronized Object take()
  {
    while(arrayList.size()<=0)
    {
      try
      {
        wait();
        //Log.getInstance().addLog(Thread.currentThread().getName()+" is waiting" + toString());
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    if(arrayList.size()==0)
    {
      notifyAll();
    }
    //Log.getInstance().addLog(Thread.currentThread().getName()+" is working");
    notifyAll();
    return arrayList.remove(arrayList.size()-1);
  }

  @Override public synchronized Object look()
  {
    if(arrayList.isEmpty())
    {
      return null;
    }
    else return arrayList.get(0);
  }

  @Override public synchronized boolean isEmpty()
  {
    return arrayList.isEmpty();
  }

  @Override public synchronized boolean isFull()
  {
    return arrayList.isFull();
  }

  @Override public synchronized int size()
  {
    return arrayList.size();
  }

  public String toString()
  {
    return arrayList.toString();
  }
}
