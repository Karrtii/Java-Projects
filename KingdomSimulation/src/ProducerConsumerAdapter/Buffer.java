package ProducerConsumerAdapter;

public interface Buffer<T>
{
  public void put(T element);
  public T take();
  public T look() throws InterruptedException;
  public boolean isEmpty();
  public boolean isFull();
  public int size();
}
