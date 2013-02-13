/**
 * Pow(x, n)
 * 
 * Implement pow(x, n).
 * 
 * http://discuss.leetcode.com/questions/228/powx-n
 */
public class Pow {
	public double pow(double x, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int p = Math.abs(n);
		double ret = 1;
		while (p > 0) {
			if (p % 2 == 1) {
				ret *= x;
			}
			p >>= 1;
			x *= x;
		}
		if (n < 0) {
			return 1 / ret;
		}
		return ret;
	}
}
