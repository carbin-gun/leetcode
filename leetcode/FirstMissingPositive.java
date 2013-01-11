/**
 * First Missing Positive
 * 
 * Given an unsorted integer array, find the first missing positive integer.
 * 
 * For example, Given [1,2,0] return 3, and [3,4,-1,1] return 2.
 * 
 * Your algorithm should run in O(n) time and uses constant space.
 * 
 * http://discuss.leetcode.com/questions/219/first-missing-positive
 */

/*
 * The idea is to store value n on array at index of n-1;
 */
public class FirstMissingPositive {
	public int firstMissingPositive(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (A.length == 0) {
			return 1;
		}
		int pointer = 0;
		while (pointer < A.length) {
			if (A[pointer] < 1 || A[pointer] > A.length
					|| A[A[pointer] - 1] == A[pointer]) {
				// A[A[pointer] - 1] == A[pointer] is necessary when has dup number.
				pointer++;
			} else {
				int index = A[pointer] - 1;
				int tmp = A[index];
				A[index] = A[pointer];
				A[pointer] = tmp;
			}
		}
		for (int i = 0; i < A.length; i++) {
			if (A[i] != i + 1) {
				return i + 1;
			}
		}
		return A.length + 1;
	}
}
