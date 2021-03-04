package View;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import ViewModel.FirstWindowViewModel;
import javafx.scene.text.Text;

public class FirstWindowController
{
  private Region root;
  private ViewHandler viewHandler;
  private FirstWindowViewModel firstWindowViewModel;
  private @FXML Button heaterSettingsButton;
  private @FXML Label temperature1Label, temperature2Label;
  private @FXML Text errorText;

  public void init(ViewHandler viewHandler, FirstWindowViewModel firstWindowViewModel, Region root)
  {
    this.viewHandler=viewHandler;
    this.firstWindowViewModel=firstWindowViewModel;
    this.root=root;
    temperature1Label.textProperty().bindBidirectional(firstWindowViewModel.getTemperature1());
    temperature2Label.textProperty().bindBidirectional(firstWindowViewModel.getTemperature2());
    firstWindowViewModel.getTemperature1().addListener((a,b,c) ->
    {
      if(firstWindowViewModel.getLastTemperature1().getValue()>23)
        errorText.setText("Temperature critical: too high.");
      else if(firstWindowViewModel.getLastTemperature2().getValue() <= 5)
        errorText.setText("Temperature critical: too low.");
      else
        errorText.setText("");
    });
  }

  public void reset()
  {

  }
  public Region getRoot()
  {
    return root;
  }
  @FXML private void heaterSettings()
  {
    viewHandler.openView("second");
  }
}
