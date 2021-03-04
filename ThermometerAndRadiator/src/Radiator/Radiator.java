package Radiator;

import Model.Model;

public class Radiator
{
  private RadiatorState state;
  private Model model;

  public Radiator(Model model)
  {
    setState(new RadiatorOff());
    this.model = model;
  }

  public void up() { state.up(this); }
  public void down() { state.down(this); }
  public void setState(RadiatorState state) { this.state = state; }
  public int getStatus() { return state.getStatus(this); }
}
