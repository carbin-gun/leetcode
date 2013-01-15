import java.util.ArrayList;

/**
 * N-Queens
 * 
 * The n-queens puzzle is the problem of placing n queens on an nÌÑn chessboard
 * such that no two queens attack each other.
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens'
 * placement, where 'Q' and '.' both indicate a queen and an empty space
 * respectively.
 * 
 * For example, There exist two distinct solutions to the 4-queens puzzle:
 * [
 * [".Q..",  // Solution 1
 * "...Q",
 * "Q...",
 * "..Q."],

 * ["..Q.",  // Solution 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * 
 * http://discuss.leetcode.com/questions/229/n-queens
 */
public class NQueens {
	public ArrayList<String[]> solveNQueens(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<String[]> ret = new ArrayList<String[]>();
		int[] location = new int[n];
		solveNQueens(ret, location, 0);
		return ret;
	}

	public void solveNQueens(ArrayList<String[]> result, int[] location, int row) {
		if (row == location.length) {
			result.add(generateString(location));
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

	public String[] generateString(int[] location) {
		String[] ret = new String[location.length];
		for (int i = 0; i < location.length; i++) {
			StringBuilder sb = new StringBuilder("");
			for (int j = 0; j < location.length; j++) {
				if (location[i] == j) {
					sb.append("Q");
				} else {
					sb.append(".");
				}
			}
			ret[i] = sb.toString();
		}
		return ret;
	}
}
