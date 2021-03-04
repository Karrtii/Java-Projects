package View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import ViewModel.ViewModelFactory;

public class ViewHandler
{
  private Scene currentScene;
  private Stage primaryStage;
  private ViewModelFactory viewModelFactory;
  private FirstWindowController firstWindowController;
  private SecondWindowController secondWindowController;

  public ViewHandler(ViewModelFactory viewModelFactory)
  {
    this.viewModelFactory = viewModelFactory;
    currentScene = new Scene(new Region());
  }

  public void start(Stage primaryStage)
  {
    this.primaryStage = primaryStage;
    openView("first");
  }

  public void openView(String id)
  {
    Region root = null;
    switch (id)
    {
      case "first":
        root = loadFirstWindow("FirstWindow.fxml");
        break;
      case "second":
        root = loadSecondWindow("SecondWindow.fxml");
        break;
    }
    currentScene.setRoot(root);
    String title = "";
    if (root.getUserData() != null)
    {
      title += root.getUserData();
    }
    primaryStage.setTitle(title);
    primaryStage.setScene(currentScene);
    primaryStage.setWidth(root.getPrefWidth());
    primaryStage.setHeight(root.getPrefHeight());
    primaryStage.show();
  }

  public void closeView()
  {
    primaryStage.close();
  }

  private Region loadFirstWindow(String fxmlFile)
  {
    if (firstWindowController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        firstWindowController = loader.getController();
        firstWindowController.init(this, viewModelFactory.getFirstWindowViewModel(), root);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      firstWindowController.reset();
    }
    return firstWindowController.getRoot();
  }


  private Region loadSecondWindow(String fxmlFile)
  {
    if (secondWindowController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        secondWindowController = loader.getController();
        secondWindowController
            .init(this, viewModelFactory.getSecondWindowViewModel(), root);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      secondWindowController.reset();
    }
    return secondWindowController.getRoot();
  }

}

