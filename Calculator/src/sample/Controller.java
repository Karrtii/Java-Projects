package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller
{
  private CalculatorModel model;
  @FXML TextField text;
  @FXML Button but0, but1, but2,but3,but4,but5,but6,but7,but8,but9,butCE,butC,butBack,butdivide,butmultiply,butplus,butminus,butequals,butcomma;

  public void Pressed0()
{
  text.setText(model.addDigit(0));
}
  public void Pressed1()
  {
    text.setText(model.addDigit(1));
  }
  public void Pressed2()
{
  text.setText(model.addDigit(2));
}public void Pressed3()
{
  text.setText(model.addDigit(3));
}
public void Pressed4()
{
  text.setText(model.addDigit(4));
}
public void Pressed5()
{
  text.setText(model.addDigit(5));
}
public void Pressed6()
{
  text.setText(model.addDigit(6));
}
public void Pressed7()
{
  text.setText(model.addDigit(7));
}
public void Pressed8()
{
  text.setText(model.addDigit(8));
}
public void Pressed9()
{
  text.setText(model.addDigit(9));
}

  public void Pressedcomma()
  {
    text.setText(model.addComma());
  }
  public void Pressedplus()
  {
    model.plus();
  }
  public void Pressedminus()
  {
    model.minus();
  }
  public void Pressedmultiply()
  {
    model.times();
  }
  public void Presseddivide()
  {
    model.divide();
  }
  public void Pressedequals()
  {
    model.equals();
  }
  public void CEPressed()
  {
    model.clearAll();
  }
  public void CPressed()
  {
    model.clear();
  }
  public void BackPressed()
  {
    model.removeLast();
  }



  public void setModel(CalculatorModel model)
  {
    this.model = model;
  }
}
