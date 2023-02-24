public class Zoo {

  public static void main(String[] args) {
    Counter counter = new Counter();
    Gate gate1 = new Gate(counter, 32);
    Gate gate2 = new Gate(counter, 48);
    Gate gate3 = new Gate(counter, 20);
    Gate gate4 = new Gate(counter, 50);
    Gate gate5 = new Gate(counter, 60);

    Thread thread1 = new Thread(gate1, "gate1");
    Thread thread2 = new Thread(gate2, "gate2");
    Thread thread3 = new Thread(gate3, "gate3");
    Thread thread4 = new Thread(gate4, "gate4");
    Thread thread5 = new Thread(gate5, "gate5");


    thread1.start();
    thread2.start();
    thread3.start();
    thread4.start();
    thread5.start();

    try {
      thread1.join();
      thread2.join();
      thread3.join();
      thread4.join();
      thread5.join();
    } catch (InterruptedException e) {
      System.err.println(e.getStackTrace());
    }

    System.out.println("number of expected guests: 210");
    System.out.println("number in counter: " + counter.getCounter());
  }

}
