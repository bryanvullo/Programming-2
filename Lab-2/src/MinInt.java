import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.recursion.MinimumInArray;

public class MinInt implements MinimumInArray {

  public static void main(String[] numbers){
    int[] arr = {24,52,74,9,34,23,64,34};
    MinInt minInt = new MinInt();
    System.out.println("Minimum is: " + minInt.findMin(arr));
  }

  public int findMin(int[] array){
		if (array.length <= 1) {
      return array[0];
    } else {
      int[] subArray = java.util.Arrays.copyOfRange(array, 1, array.length);
      return Math.min(array[0], findMin(subArray));
    }
  }
}
