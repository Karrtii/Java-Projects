package Flyweight;

import java.util.HashMap;
import java.util.Map;

public class Mine
{
  private static Map<String, Valuable> valuables = new HashMap<>();

  public static Valuable getValuable(String name)
  {
    Valuable valuable = valuables.get(name);
    if(valuable==null)
    {
      switch (name)
      {
        case "Flyweight.Diamond":
            valuable = new Diamond();
            break;
        case "Flyweight.Jewel":
          valuable = new Jewel();
          break;
        case "Flyweight.Ruby":
          valuable = new Ruby();
          break;
        case "Flyweight.WoodenCoin":
          valuable = new WoodenCoin();
          break;
        case "Flyweight.GoldNugget":
          valuable = new GoldNugget();

      }
      valuables.put(name,valuable);
    }
    return valuable;
  }

}
