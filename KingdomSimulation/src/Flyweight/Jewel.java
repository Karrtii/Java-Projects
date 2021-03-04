package Flyweight;

public class Jewel implements Valuable
{

  @Override public String getName()
  {
    return "Jewel";
  }

  @Override public int getValue()
  {
    return 30;
  }

  @Override public String toString()
  {
    return getName();
  }
}
