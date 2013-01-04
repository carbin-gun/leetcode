package array;

/**
 * Set Matrix Zeroes http://leetcode.com/questions/249/set-matrix-zeroes
 */
public class SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int m = matrix.length;
		int n = matrix[0].length;
		int row = -1;
		int column = -1;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					row = i;
					column = j;
					i = m;
					j = n;
				}
			}
		}
		if (row == -1) {
			return;
		}

		for (int i = row + 1; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					matrix[row][j] = 0;
					matrix[i][column] = 0;
				}
			}
		}

		for (int i = 0; i < m; i++) {
			if (i != row && matrix[i][column] == 0) {
				for (int j = 0; j < n; j++) {
					matrix[i][j] = 0;
				}
			}
		}

		for (int j = 0; j < n; j++) {
			if (j != column && matrix[row][j] == 0) {
				for (int i = 0; i < m; i++) {
					matrix[i][j] = 0;
				}
			}
		}

		for (int i = 0; i < m; i++) {
			matrix[i][column] = 0;
		}

		for (int j = 0; j < n; j++) {
			matrix[row][j] = 0;
		}

	}
}
