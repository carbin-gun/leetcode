package unsorted;
/**
 * Divide Two Integers
 */
public class DivideTwoInteger {
	public int divide(int dividend, int divisor) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (dividend == 0)
            return 0;
        
        boolean positive = false;
        if ((dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0)) {
            positive = true;
        }
        long dividendLong = Math.abs((long) dividend);
        long divisorLong = Math.abs((long) divisor);
        int n = 0;
        while (dividendLong >= divisorLong) {
            n++;
            divisorLong <<= 1;
        }
        int result = 0;
        while (n-- > 0) {
            divisorLong >>= 1;
            if (dividendLong >= divisorLong) {
                result <<= 1;
                result = result + 1;
                dividendLong -= divisorLong;
            } else {
                result <<= 1;
            }
        }
        if (positive)
            return result;
        else 
            return -result;
    }
}
