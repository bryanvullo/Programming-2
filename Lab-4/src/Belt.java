public class Belt extends CyclicQueue {

  public Belt(int size) {
    super(size);
  }

  public synchronized void enqueue(int item) {
    if (isFull()) {
      try {
        this.wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    super.enqueue(item);
    notify();
  }

  public synchronized int dequeue() {
    if (isEmpty()) {
      try {
        this.wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    int item = super.dequeue();
    notify();
    return item;
  }
}
