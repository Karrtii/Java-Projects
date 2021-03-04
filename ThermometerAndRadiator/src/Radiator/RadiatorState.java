package Radiator;

public interface RadiatorState
{
  public abstract void up(Radiator radiator);
  public abstract void down(Radiator radiator);
  public abstract int getStatus(Radiator radiator);
}
