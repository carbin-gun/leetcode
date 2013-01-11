

/**
 * Jump Game
 * 
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * For example: A = [2,3,1,1,4], return true.
 * 
 * A = [3,2,1,0,4], return false.
 */
public class JumpGame {
	public boolean canJump(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (A.length <= 1) {
			return true;
		}
		int max = A[0];
		for (int i = 1; i < A.length; i++) {
			if (max < i) {
				return false;
			} else {
				max = Math.max(max, i + A[i]);
			}
			if (max >= A.length - 1) {
				return true;
			}
		}
		return true;
	}
}
