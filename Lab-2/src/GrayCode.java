public class GrayCode {

  public static int[] grayCode(int n) {
    int rows = (int) Math.pow(2, n);
    int[][] arr = new int[n][rows];
    if (n < 1) {
      System.err.println("invalid input");
    } else if (n == 1) {
      return new int[] {0,1};
    } else {
      for (int i = 0; i < rows/2; i++) {
        //arr[i] = new int[]{0, grayCode(n - 1)};
      }
    }
    return null;
  }

}
