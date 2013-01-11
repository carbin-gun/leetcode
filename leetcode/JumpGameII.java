/**
 * Jump Game II Given an array of non-negative integers, you are initially
 * positioned at the first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * For example: Given array A = [2,3,1,1,4]
 * 
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from
 * index 0 to 1, then 3 steps to the last index.)
 * 
 * http://discuss.leetcode.com/questions/223/jump-game-ii
 */

/*
 * Greedy algorithm can solve this problem in O(n) time. DP can also solve this issue, 
 * however, it will takes O(n^2) time, which cannot pass the large case;
 */

public class JumpGameII {
	public int jump(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (A.length <= 1) {
			return 0;
		}

		int index = 0;
		int jumps = 0;
		while (index < A.length) {
			int curMax = index + A[index];
			if (A[index] > 0) {
				jumps++;
			} else {
				return -1;
			}
			if (curMax >= A.length - 1) {
				return jumps;
			}
			for (int i = index + 1; i <= curMax; i++) {
				if (i + A[i] > index + A[index]) {
					index = i;
				}
			}
		}
		return jumps;
	}

	public int jump_dp(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (A.length <= 1) {
			return 0;
		}
		int[] step = new int[A.length];
		step[0] = 0;
		for (int i = 1; i < A.length; i++) {
			step[i] = Integer.MAX_VALUE;
		}
		for (int i = 0; i < A.length; i++) {
			if (step[i] != Integer.MAX_VALUE) {
				if (i + A[i] <= A.length - 1) {
					for (int j = i + 1; j <= i + A[i]; j++) {
						step[j] = Math.min(step[j], step[i] + 1);
					}
				} else {
					step[A.length - 1] = Math.min(step[A.length - 1],
							step[i] + 1);
				}
			}
		}
		return step[A.length - 1];
	}
}
