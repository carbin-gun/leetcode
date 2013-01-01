package array;

/**
 * Remove Duplicates from Sorted Array II
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
