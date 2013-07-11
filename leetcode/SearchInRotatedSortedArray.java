

/**
 * Search in Rotated Sorted Array
 * key idea is to judge the rotated point is in left or right of the middle.
 * http://leetcode.com/questions/17/search-in-rotated-sorted-array
 * 
 */
public class SearchInRotatedSortedArray {
	public int search(int[] A, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		return search(A, target, 0, A.length - 1);

	}

	public int search(int[] A, int target, int start, int end) {
		if (start > end) {
			return -1;
		}
		int mid = (start + end) / 2;
		boolean rotatedLeft = A[start] > A[mid];
		if (A[mid] == target) {
			return mid;
		}
		if (rotatedLeft) {
			if (target > A[mid] && target <= A[end]) {
				return binarySearch(A, target, mid + 1, end);
			} else {
				return search(A, target, start, mid - 1);
			}
		} else {
			if (target >= A[start] && target < A[mid]) {
				return binarySearch(A, target, start, mid - 1);
			} else {
				return search(A, target, mid + 1, end);
			}

		}
	}

	public int binarySearch(int[] A, int target, int start, int end) {
		if (A.length == 0) {
			return -1;
		}
		while (start <= end) {
			int mid = (start + end) / 2;
			if (A[mid] == target) {
				return mid;
			}
			if (A[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

}
