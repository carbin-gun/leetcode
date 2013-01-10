

/**
 * Divide Two Integers
 * 
 * Divide two integers without using multiplication, division and mod operator.
 */

/*
 * The solution need to remember, one is overflow, so we need change them to
 * long, second is the negative and positive. 
 */
public class DivideTwoInteger {
	public int divide(int dividend, int divisor) {
		// Start typing your Java solution below
		// DO NOT write main() function
		boolean isPositive = true;
		if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
			isPositive = false;
		}
		long divisorLong = Math.abs((long) divisor);
		long dividendLong = Math.abs((long) dividend);
		long div = divisorLong;
		while (div << 1 <= dividendLong) { // It should be <=, not <.
			div <<= 1;
		}
		int ret = 0;
		while (div >= divisorLong) {
			ret <<= 1;
			if (dividendLong >= div) {
				ret += 1;
				dividendLong -= div;
			}
			div >>= 1;
		}
		if (isPositive) {
			return ret;
		} else {
			return -ret;
		}
	}
}
