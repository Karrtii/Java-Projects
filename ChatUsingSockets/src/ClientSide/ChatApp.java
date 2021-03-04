package src.ClientSide;

import javafx.application.Application;
import javafx.stage.Stage;
import src.ClientSide.Core.ClientFactory;
import src.ClientSide.Core.ModelFactory;
import src.ClientSide.Core.ViewHandler;
import src.ClientSide.Core.ViewModelFactory;

public class ChatApp extends Application
{
  ClientFactory cf = new ClientFactory();
  ModelFactory mf = new ModelFactory(cf);
  ViewModelFactory vmf=new ViewModelFactory(mf);
  ViewHandler viewHandler=new ViewHandler(vmf);
  public void start(Stage stage) throws Exception
  {

    viewHandler.start();
  }
  public void stop()
  {
    mf.getChat().decrementClient();
    cf=null;

  }
}

