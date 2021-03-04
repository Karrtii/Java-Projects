package Singleton;

public class Log
{
  private static Log instance;

  public static Log getInstance()
  {
    if(instance == null)
    {
      instance = new Log();
    }
    return instance;
  }

  public void addLog(String message)
  {
    System.out.println(message);
  }
}
