package array;

/**
 * Search a 2D Matrix
 * http://leetcode.com/questions/250/search-a-2d-matrix
 */
public class SearchA2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (matrix.length == 0) {
			return false;
		}
		return searchMatrix(matrix, target, 0, matrix.length);
	}

	public boolean searchMatrix(int[][] matrix, int target, int start, int end) {
		if (start == end - 1) {
			return binarySearchArray(matrix[start], target, 0,
					matrix[start].length);
		}
		int mid = (start + end) / 2;
		if (matrix[mid][0] > target) {
			return searchMatrix(matrix, target, start, mid);
		} else {
			return searchMatrix(matrix, target, mid, end);
		}
	}

	public boolean binarySearchArray(int[] arr, int target, int start, int end) {
		if (start == end - 1) {
			return arr[start] == target;
		}
		int mid = (start + end) / 2;
		if (arr[mid] > target) {
			return binarySearchArray(arr, target, start, mid);
		} else {
			return binarySearchArray(arr, target, mid, end);
		}
	}
}
