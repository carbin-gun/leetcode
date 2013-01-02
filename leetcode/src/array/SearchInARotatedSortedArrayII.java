package array;

/**
 * Search in a Rotated Sorted Array II
 * http://leetcode.com/questions/256/search-in-rotated-sorted-array-ii 
 *
 */
public class SearchInARotatedSortedArrayII {
	public boolean search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
         
        for (int i = 0; i < A.length; i++) {
            if (A[i] == target) {
                return true;
            }
        }
        return false;
    }
}
