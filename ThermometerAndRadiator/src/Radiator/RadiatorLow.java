package Radiator;

public class RadiatorLow implements RadiatorState
{
  @Override public void up(Radiator radiator)
  {
    radiator.setState(new RadiatorMedium());
  }

  @Override public void down(Radiator radiator)
  {
    radiator.setState(new RadiatorOff());
  }

  @Override public int getStatus(Radiator radiator)
  {
    return 1;
  }
}
