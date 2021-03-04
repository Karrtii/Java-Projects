package src.ClientSide.Core;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import src.ClientSide.View.ViewController;

import java.io.IOException;

public class ViewHandler
{
  private Scene usernameScene;
  private Scene chatScene;
  private ViewModelFactory vmf;
  private Stage stage;

  public ViewHandler(ViewModelFactory vmf){this.vmf = vmf;}

  public void start()
  {
    stage=new Stage();
    openUsername();
  }
  public void openUsername() {
    if (usernameScene == null) {
      try {
        Parent root = loadFXML("../View/UsernameConfig.fxml");

        stage.setTitle("Setting username");
        usernameScene = new Scene(root);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    stage.setScene(usernameScene);
    stage.show();
  }

  public void openChat() {
    // no reusing a logScene, because I want the log to reload the latest every time.
    if (chatScene == null) {
      try {
        Parent root = loadFXML("../View/ChatWindow.fxml");

        chatScene = new Scene(root);
        stage.setTitle("Chat");

      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    stage.setScene(chatScene);
    stage.show();
  }

  private Parent loadFXML(String path) throws IOException
  {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource(path));
    Parent root = loader.load();

    ViewController ctrl = loader.getController();
    ctrl.init(this, vmf);
    return root;
  }
}
