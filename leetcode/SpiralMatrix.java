

import java.util.ArrayList;

/**
 * Spiral Matrix
 * 
 */
public class SpiralMatrix {
	public ArrayList<Integer> spiralOrder(int[][] matrix) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (matrix.length == 0) {
			return new ArrayList<Integer>();
		}
		return spiralOrder(matrix, 0, 0, matrix.length, matrix[0].length);
	}

	public ArrayList<Integer> spiralOrder(int[][] matrix, int x, int y, int m,
			int n) {
		ArrayList<Integer> seq = new ArrayList<Integer>();

		if (m <= 0 || n <= 0) {
			return seq;
		}

		// be careful of the 4 corners, do not duplicate them
		// top side
		for (int j = y; j < y + n; j++) {
			seq.add(matrix[x][j]);
		}
		// right side
		for (int i = x + 1; i < x + m - 1; i++) {
			seq.add(matrix[i][y + n - 1]);
		}

		// bot side
		if (m > 1) {
			for (int j = y + n - 1; j >= y; j--) {
				seq.add(matrix[x + m - 1][j]);
			}
		}

		// left side
		if (n > 1) {
			for (int i = x + m - 2; i > x; i--) {
				seq.add(matrix[i][y]);
			}
		}
		seq.addAll(spiralOrder(matrix, x + 1, y + 1, m - 2, n - 2));

		return seq;
	}

	public ArrayList<Integer> spiralOrderNoRecurive(int[][] matrix) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> re = new ArrayList<Integer>();
		int m = matrix.length;
		if (m == 0) {
			return re;
		}
		int n = matrix[0].length;
		int i = 0;
		int j = 0;
		int total = n * m;
		int direct = 0;
		boolean rowReduce = false;
		boolean columnReduce = false;
		if (n == 1) {
			direct = 1;
		}
		int curMove = 0;
		while (total > 0) {
			re.add(matrix[i][j]);
			System.out.println(matrix[i][j]);
			total--;
			if (direct == 0) {
				j++;
				curMove++;
				if (curMove == n - 1) {
					if (rowReduce) {
						m--;
					} else {
						rowReduce = true;
					}
					direct++;
					curMove = 0;
				}
			} else if (direct == 1) {
				i++;
				curMove++;
				if (curMove == m - 1) {
					if (columnReduce) {
						n--;
					} else {
						columnReduce = true;
					}
					direct++;
					curMove = 0;
				}
			} else if (direct == 2) {
				j--;
				curMove++;
				if (curMove == n - 1) {
					m--;
					direct++;
					curMove = 0;
				}
			} else {
				i--;
				curMove++;
				if (curMove == m - 1) {
					direct = 0;
					n--;
					curMove = 0;
				}
			}
		}
		return re;
	}

	public static void main(String argv[]) {
		SpiralMatrix sm = new SpiralMatrix();
		int[][] matrix = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 },
				{ 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
				{ 21, 22, 23, 24, 25 } };
		sm.spiralOrder(matrix);

	}
}
