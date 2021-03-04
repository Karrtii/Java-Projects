package Model;

import utilities.NamedPropertyChangeSubject;

public interface Model extends NamedPropertyChangeSubject
{
  public void addTemperature(String id, double value);
  public void up();
  public void down();
  public int getState();
  public Temperature getLastInsertedTemperature();
  public Temperature getLastInsertedTemperature(String id);
}
