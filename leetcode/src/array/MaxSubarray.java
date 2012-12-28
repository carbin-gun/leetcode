package array;
/**
 * Maximum Subarray 
 *
 */
public class MaxSubarray {
	public int maxSubArray(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int sum = Integer.MIN_VALUE;
        int preSum = 0;
        for (int i = 0; i < A.length; i++) {
            sum = Math.max(sum, preSum + A[i]);
            if (preSum + A[i] > 0) {
                preSum += A[i];
            } else {
                preSum = 0;
            }
        }
        return sum;
    }
}
