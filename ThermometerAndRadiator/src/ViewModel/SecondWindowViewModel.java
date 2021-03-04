package ViewModel;

import Model.Model;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SecondWindowViewModel implements PropertyChangeListener
{
  private Model model;
  private StringProperty heaterLevel;

  public SecondWindowViewModel(Model model)
  {
    this.model=model;
    this.heaterLevel = new SimpleStringProperty();
    model.addListener("power", this);
  }

  public StringProperty getHeaterLevel()
  {
    return heaterLevel;
  }

  public void up()
  {
    model.up();
  }
  public void down()
  {
    model.down();
  }

  @Override public void propertyChange(PropertyChangeEvent propertyChangeEvent)
  {
    Platform.runLater(()->
    {
      heaterLevel.setValue(propertyChangeEvent.getNewValue().toString());
    });
  }
}
