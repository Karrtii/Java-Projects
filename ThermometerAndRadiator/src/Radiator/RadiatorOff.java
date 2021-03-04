package Radiator;

public class RadiatorOff implements RadiatorState
{
  @Override public void up(Radiator radiator)
  {
    radiator.setState(new RadiatorLow());
  }

  @Override public void down(Radiator radiator)
  {
    //do nothing
  }

  @Override public int getStatus(Radiator radiator)
  {
    return 0;
  }
}
