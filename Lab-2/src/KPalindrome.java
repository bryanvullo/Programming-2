import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.recursion.PalindromeChecker;

public class KPalindrome implements PalindromeChecker {

  public boolean isKPalindrome(String string, int k) {
    if (k < 0) {
      return false;
    } else if (string.length() <= 1) {
      return true;
    } else {
      if (string.charAt(0) == string.charAt(string.length()-1)) {
        String substring = string.substring(1, string.length()-1);
        return isKPalindrome(substring, k);
      } else {
        String left = string.substring(0, string.length()-1);
        String right = string.substring(1, string.length());
        return (isKPalindrome(left, k-1) || isKPalindrome(right, k-1));
      }
    }
  }
}
