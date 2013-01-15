/**
 * N-Queens II Now, instead outputting board configurations, return the total
 * number of distinct solutions.
 * 
 * http://discuss.leetcode.com/questions/230/n-queens-ii
 */

/*
 * DFS
 */
public class NQueensII {
	public int totalNQueens(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int[] ret = new int[1];
		int[] location = new int[n];
		solveNQueens(ret, location, 0);
		return ret[0];
	}

	public void solveNQueens(int[] result, int[] location, int row) {
		if (row == location.length) {
			result[0]++;
			return;
		}
		int[] available = findAvailable(location, row);
		for (int i = 0; i < available.length; i++) {
			if (available[i] == 0) {
				location[row] = i;
				solveNQueens(result, location, row + 1);
			}
		}
		return;
	}

	public int[] findAvailable(int[] location, int row) {
		int[] notAvailable = new int[location.length];
		for (int i = 0; i < row; i++) {
			notAvailable[location[i]] = 1;
			if (location[i] - row + i >= 0) {
				notAvailable[location[i] - row + i] = 1;
			}
			if (location[i] + row - i < notAvailable.length) {
				notAvailable[location[i] + row - i] = 1;
			}
		}
		return notAvailable;
	}
}
