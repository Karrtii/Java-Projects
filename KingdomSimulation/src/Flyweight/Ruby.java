package Flyweight;

public class Ruby implements Valuable
{

  @Override public String getName()
  {
    return "Ruby";
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
