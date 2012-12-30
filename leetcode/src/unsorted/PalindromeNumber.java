package unsorted;

/**
 * Palindrome Number
 * 
 */
public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (x < 0)
			return false;
		int i = 0;
		int n = x;
		while (n / 10 > 0) {
			i++;
			n = n / 10;
		}
		return isPalindrome(x, i);
		
	}
	
	public boolean isPalindrome(int x, int i) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (x < 10) {
			return true;
		}
		int high = x / (int) Math.pow(10, i);
		int low = x % 10;
		if (high == low) {
			return isPalindrome((x - high * (int) Math.pow(10, i)) / 10, i - 2);
		} else {
			return false;
		}
	}

	public static void main(String argv[]) {
		PalindromeNumber p = new PalindromeNumber();
		System.out.println(p.isPalindrome(2140110412));
	}
}
