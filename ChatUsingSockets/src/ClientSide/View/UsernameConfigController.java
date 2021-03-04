package src.ClientSide.View;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import src.ClientSide.Core.ViewHandler;
import src.ClientSide.Core.ViewModelFactory;

public class UsernameConfigController implements ViewController
{
  private UsernameConfigViewModel usernameConfigViewModel;
  private ViewHandler viewHandler;
  @FXML private Label errorLabel;
  @FXML private TextField username;

  public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    this.viewHandler=vh;
    this.usernameConfigViewModel=vmf.getUsernameConfigViewModel();
    errorLabel.textProperty().bind(usernameConfigViewModel.getError());
    username.textProperty().bindBidirectional(usernameConfigViewModel.getUsername());
  }

  @FXML private void onSubmit()
  {
    if(usernameConfigViewModel.setUsername())
    {
      viewHandler.openChat();
    }
  }
}
