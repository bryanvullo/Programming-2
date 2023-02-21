import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.threading.UnitCounter;

public class Counter implements UnitCounter {
  private int counter = 0;

  public void addOne() {
    counter++;
  }

  public int getCounter() {
    return counter;
  }

  public static void main(String[] args) {
    Counter counter1 = new Counter();
    counter1.addOne();
    counter1.addOne();
    counter1.addOne();
    System.out.println(counter1.getCounter());
  }
}
