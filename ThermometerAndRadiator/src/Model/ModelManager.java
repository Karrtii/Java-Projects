package Model;

import Radiator.Radiator;
import javafx.application.Platform;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ModelManager implements Model
{
  private Radiator radiator;
  private PropertyChangeSupport support;
  private TemperatureList temperatureList;

  public ModelManager()
  {
    temperatureList = new TemperatureList();
    this.support = new PropertyChangeSupport(this);
    this.radiator = new Radiator(this);
    Platform.runLater(()->support.firePropertyChange("power",null, radiator.getStatus()));
  }

  @Override public synchronized void addTemperature(String id, double value)
  {
    Temperature temperature = new Temperature(id, value, this);
    Temperature old = getLastInsertedTemperature(id);
    this.temperatureList.addTemperature(temperature);
    //                                    name                  old_value            new_value
    support.firePropertyChange("temperature", temperature.getId(), temperature.getValue());
  }

  @Override public synchronized void up()
  {
    radiator.up();
    support.firePropertyChange("power", null, radiator.getStatus());
  }

  @Override public synchronized void down()
  {
    radiator.down();
    support.firePropertyChange("power", null, radiator.getStatus());
  }

  @Override public synchronized int getState()
  {
    support.firePropertyChange("power", null, radiator.getStatus());
    return radiator.getStatus();
  }

  @Override public synchronized Temperature getLastInsertedTemperature()
  {
    return temperatureList.getLastTemperature(null);
  }

  @Override public synchronized Temperature getLastInsertedTemperature(String id)
  {
    return temperatureList.getLastTemperature(id);
  }

  @Override public void addListener(String namedProperty,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(namedProperty, listener);
  }

  @Override public void removeListener(String namedProperty,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(namedProperty, listener);
  }
}
