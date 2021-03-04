import ProducerConsumerAdapter.Buffer;
import ProducerConsumerAdapter.Deposit;
import ProducerConsumerAdapter.Miner;
import ProducerConsumerAdapter.ValuableTransporter;
import ReadersWritersProxy.Accountant;
import ReadersWritersProxy.Guardsman;
import ReadersWritersProxy.King;

public class Test
{
  public static void main(String[] args)
  {
    Guardsman guardsman = new Guardsman();
    Buffer buffer = new Deposit(10);
    King king = new King(guardsman);
    Miner miner = new Miner(buffer);
    Miner miner1 = new Miner(buffer);
    ValuableTransporter valuableTransporter = new ValuableTransporter(buffer,guardsman);
    Accountant accountant = new Accountant(guardsman);
    Accountant accountant1 = new Accountant(guardsman);
    Thread thread = new Thread(miner,"Miner1");
    Thread thread1 = new Thread(valuableTransporter,"Transporter");
    Thread thread2 = new Thread(king,"King");
    Thread thread3 = new Thread(accountant,"Accountant1");
    Thread thread4 = new Thread(miner1,"Miner2");
    Thread thread5 = new Thread(accountant1,"Accountant2");
    thread.start();
    thread1.start();
    thread2.start();
    thread3.start();
    thread4.start();
    thread5.start();
  }
}
