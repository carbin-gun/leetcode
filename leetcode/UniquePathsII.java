

/**
 * Unique Paths II 
 * http://discuss.leetcode.com/questions/239/unique-paths-ii
 */
public class UniquePathsII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
			return 0;
		}
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] ret = new int[m][n];
		if (obstacleGrid[0][0] == 1) {
			return 0;
		}
		ret[0][0] = 1;
		for (int i = 1; i < m; i++) {
			if (obstacleGrid[i][0] == 0) {
				ret[i][0] = ret[i - 1][0];
			} else {
				ret[i][0] = 0;
			}
		}

		for (int i = 1; i < n; i++) {
			if (obstacleGrid[0][i] == 0) {
				ret[0][i] = ret[0][i - 1];
			} else {
				ret[0][i] = 0;
			}
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				ret[i][j] = obstacleGrid[i][j] == 1 ? 0 : ret[i - 1][j]
						+ ret[i][j - 1];
			}
		}
		return ret[m - 1][n - 1];

	}
}
