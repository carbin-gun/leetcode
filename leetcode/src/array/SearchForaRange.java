package array;

/**
 * Search for a Range
 * the idea is to find the largest element which is larger or equals to target, and target - 1. 
 * then we can get the range.
 * http://leetcode.com/questions/213/search-for-a-range
 */
public class SearchForaRange {
	public int[] searchRange(int[] A, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int[] ret = new int[2];
		ret[0] = firstNotBigger(A, target - 1) + 1;
		ret[1] = firstNotBigger(A, target);
		if (ret[1] == -1 || A[ret[1]] != target) {
			ret[1] = -1;
			ret[0] = -1;
		}
		return ret;
	}

	public int firstNotBigger(int[] A, int target) {
		int start = 0;
		int end = A.length - 1;
		int position = -1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (A[mid] > target) {
				end = mid - 1;
			} else {
				position = mid;
				start = mid + 1;
			}
		}
		return position;
	}
}
