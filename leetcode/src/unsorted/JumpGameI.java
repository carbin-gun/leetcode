package unsorted;

/**
 * Jump Game
 * 
 */
public class JumpGameI {
	public boolean canJump(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (A.length <= 1) {
			return true;
		}
		int maxReached = 0;
		for (int i = 0; i < A.length - 1; i++) {
			if (i <= maxReached) {
				if (i + A[i] < A.length - 1) {
					maxReached = Math.max(maxReached, i + A[i]);
				} else if (i + A[i] >= A.length - 1) {
					return true;
				}
			}
		}
		return false;
	}
}
