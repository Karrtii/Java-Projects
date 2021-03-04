import Thermometer.Thermometer;
import javafx.application.Application;
import javafx.stage.Stage;
import Model.Model;
import Model.ModelManager;
import View.ViewHandler;
import ViewModel.ViewModelFactory;

public class MyApplication extends Application
{
  public void start(Stage primaryStage)
  {
    Model model = new ModelManager();
    ViewModelFactory viewModelFactory = new ViewModelFactory(model);
    ViewHandler view = new ViewHandler(viewModelFactory);
    view.start(primaryStage);

    Thermometer t1 = new Thermometer("t1", 0, 1, model);
    Thermometer t2 = new Thermometer("t2", 0, 7, model);
    Thread thread1 = new Thread(t1);
    Thread thread2 = new Thread(t2);

    thread1.setDaemon(true);
    thread2.setDaemon(true);

    thread1.start();
    thread2.start();
  }
}