

/**
 * Remove Duplicates from Sorted Array II
 * 
 * Follow up for "Remove Duplicates": What if duplicates are allowed at most
 * twice?
 * 
 * For example, Given sorted array A = [1,1,1,2,2,3],
 * 
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 * 
 * http://leetcode.com/questions/255/remove-duplicates-from-sorted-array-ii
 * 
 */

public class RemoveDuplicatesFromSortedArrayII {
	public int removeDuplicates(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (A.length <= 2) {
			return A.length;
		}

		int noDup = 1;
		int end = 2;

		while (end < A.length) {
			if (A[end] != A[noDup - 1]) {
				A[++noDup] = A[end];
			}
			end++;
		}
		return noDup + 1;
	}
}
