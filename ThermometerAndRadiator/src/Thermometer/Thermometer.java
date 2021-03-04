package Thermometer;

import Model.Model;

public class Thermometer implements Runnable
{
  private final static int STARTING_TEMPERATURE = 0;

  private String id;
  private double t;  //temperature
  private int d;     //distance
  private Model model;

  public Thermometer(String id, double t, int d, Model model)
  {
    this.t = t;
    this.id = id;
    this.d = d;
    this.model = model;
  }

  public double temperature(double t, int p, double t0, int s)
  {
    double tMax = Math.min(11 * p + 10, 11 * p + 10 + t0);
    tMax = Math.max(Math.max(t, tMax), t0);
    double heaterTerm = 0;
    if (p > 0)
    {
      double den = Math.max((tMax * (20 - 5 * p) * (d + 5)), 0.1);
      heaterTerm = 30 * s * Math.abs(tMax - t) / den;
    }
    double outdoorTerm = (t - t0) * s / 250.0;
    t = Math.min(Math.max(t - outdoorTerm + heaterTerm, t0), tMax);
    return t;
  }

  public double externalTemperature(double t0, double min, double max)
  {
    double left = t0 - min;
    double right = max - t0;
    int sign = Math.random() * (left + right) > left ? 1 : - 1;
    t0 += sign * Math.random();
    return t0;
  }

  @Override public void run()
  {
    while (true)
    {
      t = temperature(t, model.getState(), STARTING_TEMPERATURE, 6);
      model.addTemperature(id,t);

      try
      {
        Thread.sleep(4000); //refresh every ms
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }
}
