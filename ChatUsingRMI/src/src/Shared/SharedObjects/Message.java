package src.Shared.SharedObjects;

import java.io.Serializable;

public class Message implements Serializable
{

  private String name;
  private String message;

  public Message(String name, String message)
  {
    this.message = message;
    this.name = name;
  }

  public String getMessage()
  {
    return message;
  }

  public String getName()
  {
    return name;
  }

  public String toString()
  {
    return getName()+": "+getMessage();
  }
}
