package View;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import ViewModel.SecondWindowViewModel;

public class SecondWindowController
{
  private Region root;
  private ViewHandler viewHandler;
  private SecondWindowViewModel secondWindowViewModel;
  private @FXML Button temperatureButton, heaterDownButton, heaterUpButton;
  private @FXML Label heatingLevel;

  public void init(ViewHandler viewHandler, SecondWindowViewModel secondWindowViewModel, Region root)
  {
    this.viewHandler=viewHandler;
    this.secondWindowViewModel=secondWindowViewModel;
    this.root=root;
    heatingLevel.textProperty().bindBidirectional(secondWindowViewModel.getHeaterLevel());
  }
  public void reset()
  {

  }
  public Region getRoot()
  {
    return root;
  }
  private @FXML void temperatureButton()
  {
    viewHandler.openView("first");
  }
  private @FXML void heaterDown()
  {
    secondWindowViewModel.down();
  }
  private @FXML void heaterUp()
  {
    secondWindowViewModel.up();
  }
}
