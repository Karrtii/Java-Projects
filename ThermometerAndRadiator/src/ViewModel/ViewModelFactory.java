package ViewModel;

import Model.Model;

public class ViewModelFactory
{
  private FirstWindowViewModel firstWindowViewModel;
  private SecondWindowViewModel secondWindowViewModel;

  public ViewModelFactory(Model model)
  {
    firstWindowViewModel = new FirstWindowViewModel(model);
    secondWindowViewModel = new SecondWindowViewModel(model);
  }

  public FirstWindowViewModel getFirstWindowViewModel()
  {
    return firstWindowViewModel;
  }

  public SecondWindowViewModel getSecondWindowViewModel()
  {
    return secondWindowViewModel;
  }
}
