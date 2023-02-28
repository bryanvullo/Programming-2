import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.threading.FactoryWorker;
import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.threading.NumberQueue;

public class Consumer extends FactoryWorker {

  public Consumer(int id, NumberQueue belt) {
    super("Consumer", id, belt);
  }

  public void message(int number) {
    System.out.println(this.jobType + " " + this.id + " picked " + number + " from the belt.");
  }

  public int action() {
    return this.belt.dequeue();
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
}
