package Radiator;

public class RadiatorHigh implements RadiatorState
{
  private static final int RADIATOR_TIMEOUT = 40000; //milliseconds

  private Thread timer;
  private boolean completed;

  public RadiatorHigh(Radiator radiator)
  {
    completed = false;
    timer = new Thread(() -> {
      try
      {
        Thread.sleep(RADIATOR_TIMEOUT);
        timeout(radiator);
      }
      catch (InterruptedException e)
      {
        //do nothing
      }
    });
    timer.start();
  }

  public synchronized void timeout(Radiator radiator)
  {
    if(!completed)
    {
      completed = true;
      radiator.setState(new RadiatorMedium());
    }
  }

  @Override public synchronized void down(Radiator radiator)
  {
    if(!completed)
    {
      timer.interrupt();
      radiator.setState(new RadiatorMedium());
      completed = true;
    }
  }

  @Override public int getStatus(Radiator radiator)
  {
    return 3;
  }

  @Override public void up(Radiator radiator)
  {
    //do nothing
  }
}
