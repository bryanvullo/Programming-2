public class Gate implements Runnable{

  private Counter counter;
  private int guests;

  public Gate(Counter counter, int guests) {
    this.counter = counter;
    this.guests = guests;
  }

  public void run() {
    for (int i = 0; i < guests; i++) {
      counter.addOne();
      System.out.println(Thread.currentThread().getName() + "has added to the counter");
    }
  }
}
