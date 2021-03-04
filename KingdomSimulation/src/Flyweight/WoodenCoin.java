package Flyweight;

public class WoodenCoin implements Valuable
{
  @Override public String getName()
  {
    return "WoodenCoin";
  }

  @Override public int getValue()
  {
    return 10;
  }

  @Override public String toString()
  {
    return getName();
  }
}
