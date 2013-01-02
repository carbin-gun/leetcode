package unsorted;

/**
 * Reverse Integer
 * 
 */
public class ReverseInteger {
	public int reverse(int x) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = Math.abs(x);
		int reverse = 0;
		while (n > 0) {
			reverse = reverse * 10 + n % 10;
			n /= 10;
		}
		if (x < 0) {
			return -reverse;
		}
		return reverse;
	}
}
