/**
 * Remove Duplicates from Sorted Array
 * 
 * Given a sorted array, remove the duplicates in place such that each element
 * appear only once and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this in place with
 * constant memory.
 * 
 * For example, Given input array A = [1,1,2],
 * 
 * Your function should return length = 2, and A is now [1,2].
 * 
 * http://leetcode.com/questions/207/remove-duplicates-from-sorted-array
 * 
 */
public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (A.length <= 1) {
			return A.length;
		}
		int newIndex = 0;
		for (int i = 1; i < A.length; i++) {
			if (A[i] != A[newIndex]) {
				newIndex++;
				A[newIndex] = A[i];
			}
		}
		return newIndex + 1;
	}
}
