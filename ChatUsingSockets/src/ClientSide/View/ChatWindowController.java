package src.ClientSide.View;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import src.ClientSide.Core.ViewHandler;
import src.ClientSide.Core.ViewModelFactory;
import src.Shared.SharedObjects.Message;

public class ChatWindowController implements ViewController
{
  private ChatWindowViewModel chatWindowViewModel;
  private ViewHandler viewHandler;
  @FXML private ListView<Message> listView;
  @FXML private TextField messageField;
  @FXML private Label number;


  public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory)
  {
    this.viewHandler=viewHandler;
    this.chatWindowViewModel=viewModelFactory.getChatWindowViewModel();
    chatWindowViewModel.loadMessages();
    listView.setItems(chatWindowViewModel.getList());
    messageField.textProperty().bindBidirectional(chatWindowViewModel.getMessage());
    number.textProperty().bind(chatWindowViewModel.numberProperty());
  }
  public void sendMessage()
  {
    chatWindowViewModel.sendMessage();
    messageField.clear();
  }
  public void numberOfClients()
  {
    chatWindowViewModel.getNumber();
  }
}
