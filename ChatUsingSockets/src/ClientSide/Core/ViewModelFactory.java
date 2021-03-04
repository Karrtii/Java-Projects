package src.ClientSide.Core;


import src.ClientSide.View.ChatWindowViewModel;
import src.ClientSide.View.UsernameConfigViewModel;

public class ViewModelFactory
{
  private final ModelFactory mf;
  private UsernameConfigViewModel usernameConfigViewModel;
  private ChatWindowViewModel chatWindowViewModel;

  public ViewModelFactory(ModelFactory mf){this.mf=mf;}

  public UsernameConfigViewModel getUsernameConfigViewModel()
  {
    if(usernameConfigViewModel==null)
      usernameConfigViewModel= new UsernameConfigViewModel(mf.getChat());
    return usernameConfigViewModel;
  }
  public ChatWindowViewModel getChatWindowViewModel()
  {
    return (chatWindowViewModel = chatWindowViewModel == null ?
        new ChatWindowViewModel(mf.getChat()) : chatWindowViewModel);
  }
}
