package Radiator;

public class RadiatorMedium implements RadiatorState
{
  @Override public void up(Radiator radiator)
  {
    radiator.setState(new RadiatorHigh(radiator));
  }

  @Override public void down(Radiator radiator)
  {
    radiator.setState(new RadiatorLow());
  }

  @Override public int getStatus(Radiator radiator)
  {
    return 2;
  }
}
