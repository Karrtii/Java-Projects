package ViewModel;

import Model.Model;
import Model.Temperature;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class FirstWindowViewModel implements PropertyChangeListener
{
  private Model model;
  private StringProperty temperature1;
  private StringProperty temperature2;

  public FirstWindowViewModel(Model model)
  {
    this.model=model;
    this.temperature1 = new SimpleStringProperty();
    this.temperature2 = new SimpleStringProperty();
    model.addListener("temperature", this);
  }

  public StringProperty getTemperature1(){ return temperature1; }
  public StringProperty getTemperature2(){ return temperature2; }

  @Override public void propertyChange(PropertyChangeEvent propertyChangeEvent)
  {
    Platform.runLater(()->
    {
      if(propertyChangeEvent.getOldValue()=="t1")
        temperature1.setValue(propertyChangeEvent.getNewValue().toString());
      if(propertyChangeEvent.getOldValue()=="t2")
        temperature2.setValue(propertyChangeEvent.getNewValue().toString());
    });
  }

  public Temperature getLastTemperature1()
  {
    return model.getLastInsertedTemperature("t1");
  }
  public Temperature getLastTemperature2()
  {
    return model.getLastInsertedTemperature("t2");
  }
}
