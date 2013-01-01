package array;

/**
 * Remove Duplicates from Sorted Array
 * http://leetcode.com/questions/207/remove-duplicates-from-sorted-array 
 *
 */
public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if (A.length == 0) {
			return 0;
		}
        int noDup = 0;
        int end = 1;
        
        while (end < A.length) {
        	if (A[end] != A[noDup]) {
        		A[++noDup] = A[end];
        	}
        	end++;
        }
        return noDup + 1;
    }
}
