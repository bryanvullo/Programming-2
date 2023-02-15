import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.threading.NumberQueue;

public class CyclicQueue implements NumberQueue {
  private int[] array;
  private int size;
  private int head;
  private int tail;

  public CyclicQueue(int size) {
    array = new int[size + 1]; //the extra space is the buffer for full arrays
    this.size = size;
    head = 0;
    tail = 0;
  }

  public void enqueue(int item) throws IndexOutOfBoundsException {
    if ((tail == size && head == 0) //if tail is at the end and head is at the start
        || head == tail + 1) { //if the tail is behind the head
      throw new IndexOutOfBoundsException("The Queue is Full!");
    }
    array[tail] = item;
    tail++;
    if (tail == size + 1) {
      tail = 0;
    }
  }


  public int dequeue() throws IndexOutOfBoundsException {
    if (head == tail) {
      throw new IndexOutOfBoundsException("The Queue is Empty!");
    }
    int item = array[head];
    head++;
    if (head == size + 1) {
      head = 0;
    }
    return item;
  }


  public boolean isEmpty() {
    return head == tail;
  }

  public boolean isFull() {
    return head == tail + 1;
  }

  public static void main(String[] args) {
    CyclicQueue q = new CyclicQueue(5);
    try {
      q.enqueue(1);
      q.enqueue(2);
      q.enqueue(3);
      q.enqueue(4);
      q.enqueue(5);
      System.out.println(q.dequeue());
      System.out.println(q.dequeue());
      System.out.println(q.dequeue());
      System.out.println(q.dequeue());
      q.enqueue(6);
      q.enqueue(7);
      System.out.println(q.dequeue());
      System.out.println(q.dequeue());
      System.out.println(q.isEmpty());
      System.out.println(q.dequeue());
      System.out.println(q.isEmpty());

    } catch (IndexOutOfBoundsException e) {
      System.err.println(e);
    }
  }
}
