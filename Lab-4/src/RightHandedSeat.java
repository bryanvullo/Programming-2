import java.util.concurrent.locks.ReentrantLock;
import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.threading.Seat;

public class RightHandedSeat implements Seat {

  ReentrantLock leftFork;
  ReentrantLock rightFork;

  public void askFork1() {
    rightFork.lock();
  }

  public void askFork2() {
    leftFork.lock();
  }

  public void assignForks(ReentrantLock leftFork, ReentrantLock rightFork) {
    this.leftFork = leftFork;
    this.rightFork = rightFork;
  }
}