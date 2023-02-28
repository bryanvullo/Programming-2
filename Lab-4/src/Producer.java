import java.util.Random;
import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.threading.FactoryWorker;
import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.threading.NumberQueue;

public class Producer extends FactoryWorker {
  private Random random;

  public Producer(int id, NumberQueue belt) {
    super("Producer", id, belt);
    random = new Random();
  }

  public void message(int number) {
    System.out.println(this.jobType + " " + this.id + " added " + number + " to the belt.");
  }

  public int action() {
    int number = random.nextInt(10000, 99999);
    this.belt.enqueue(number);
    return number;
  }

  public void run() {
    while (!Thread.currentThread().isInterrupted()) {
      try {
        int number = action();
        message(number);
      } catch (Exception e) {
        messageError();
        break;
      }
    }
  }

  public static void main(String[] args) {
    CyclicQueue queue = new CyclicQueue(20);
    Producer producer = new Producer(1, queue);
    Consumer consumer = new Consumer(2,queue);

    Thread pt = new Thread(producer, "producer");
    Thread ct = new Thread(consumer, "consumer");

    pt.start();
    ct.start();
  }
}
