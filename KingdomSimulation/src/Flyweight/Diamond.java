package Flyweight;

public class Diamond implements Valuable
{
  @Override public String getName()
  {
    return "Diamond";
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
