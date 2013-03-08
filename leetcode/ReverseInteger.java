/**
 * Reverse Integer
 * 
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321 Example2: x = -123, return -321
 * 
 * http://discuss.leetcode.com/questions/191/reverse-integer
 */
public class ReverseInteger {
	public int reverse(int x) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int v = Math.abs(x);
		int ret = 0;
		while (v > 0) {
			ret = ret * 10;
			ret += v % 10;
			v = v / 10;
		}
		if (x < 0) {
			return -1 * ret;
		} else {
			return ret;
		}
	}
}
