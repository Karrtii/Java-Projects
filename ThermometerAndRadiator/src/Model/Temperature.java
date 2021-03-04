package Model;

public class Temperature
{
  private String id;
  private double value;
  private Model model;

  public Temperature(String id, double value, Model model)
  {
    this.id = id;
    this.value = value;
    this.model= model;
  }

  public double getValue() { return Math.round(value); }
  public Model getModel() { return model; }
  public String getId() { return id; }
}
