

/**
 * Search Insert Position
 * http://leetcode.com/questions/214/search-insert-position
 * key idea is to binary search the first place that no equals to or larger than s;
 */

class SearchInsertPosition {
	public int searchInsert(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
    int start = 0; 
    int end = A.length - 1;
    int ret = -1;
	
	while (start <= end) {
		int mid = (start + end) / 2;
		if (A[mid] >= target) {
			end = mid - 1;
		} else {
			ret = mid;
			start = mid + 1;
		}
	}
	return ret + 1;
    	    
    }
}
