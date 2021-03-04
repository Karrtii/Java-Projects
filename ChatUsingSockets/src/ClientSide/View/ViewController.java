package src.ClientSide.View;

import src.ClientSide.Core.ViewHandler;
import src.ClientSide.Core.ViewModelFactory;

public interface ViewController
{
  void init(ViewHandler vh, ViewModelFactory vmf);
}
