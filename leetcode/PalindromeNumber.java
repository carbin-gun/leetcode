/**
 * Palindrome Number
 * 
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * http://discuss.leetcode.com/questions/181/palindrome-number
 */

/*
 * Two method is provide here, one is recursive one is straight forward method.
 * I prefer the straight forward method.
 */
public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (x < 0) {
			return false;
		}
		int bit = 1;
		int tens = 1;
		while (x / 10 >= tens) {
			bit++;
			tens *= 10;
		}

		for (int i = 0; i < bit / 2; i++) {
			int m = x % 10;
			int n = x / tens;
			if (n != m) {
				return false;
			} else {
				x -= n * tens;
				x /= 10;
				tens /= 100;
			}
		}
		return true;
	}

	public boolean isPalindromeold(int x) {
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
		System.out.println(p.isPalindrome(10));
	}
}
