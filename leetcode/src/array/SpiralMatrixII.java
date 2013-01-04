package array;

/**
 * Spiral Matrix II
 * http://leetcode.com/questions/29/spiral-matrix
 */
public class SpiralMatrixII {
	public int[][] generateMatrix(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int[][] re = new int[n][n];
		if (n == 0) {
			return re;
		}
		setMatrix(re, 0, n - 1, 1);
		return re;
	}

	public void setMatrix(int[][] a, int s, int e, int value) {
		if (s > e) {
			return;
		}
		if (s == e) {
			a[s][e] = value;
			return;
		}
		for (int j = s; j <= e; j++) {
			a[s][j] = value++;
		}
		for (int i = s + 1; i <= e; i++) {
			a[i][e] = value++;
		}
		for (int j = e - 1; j >= s; j--) {
			a[e][j] = value++;
		}
		for (int i = e - 1; i > s; i--) {
			a[i][s] = value++;
		}
		setMatrix(a, s + 1, e - 1, value);
	}
}
