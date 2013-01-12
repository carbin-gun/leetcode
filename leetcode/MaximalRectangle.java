import java.util.Stack;

/**
 * Maximal Rectangle Given a 2D binary matrix filled with 0's and 1's, find the
 * largest rectangle containing all ones and return its area.
 * 
 */

/*
 * This is a o(n ^ m) method, however it can not pass large case.
 */
public class MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int max = 0;
		if (matrix.length == 0) {
			return 0;
		}
		int[] height = new int[matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < height.length; j++) {
				if (matrix[i][j] == '1') {
					height[j]++;
				} else {
					height[j] = 0;
				}
			}
			max = Math.max(max, maxRectangle(height));
		}
		return max;
	}

	public int maxRectangle(int[] height) {
		int max = 0;
		if (height.length == 0) {
			return 0;
		}
		Stack<Integer> in = new Stack<Integer>();
		int p = 0;
		while (p < height.length) {
			if (in.isEmpty() || height[in.peek()] < height[p]) {
				in.push(p);
				p++;
			} else {
				int h = in.pop();
				// be careful, always make mistake here;
				int width = in.isEmpty() ? p : p - in.peek() - 1;
				max = Math.max(max, height[h] * width);
			}
		}
		while (!in.isEmpty()) {
			int h = in.pop();
			int width = in.isEmpty() ? p : p - in.peek() - 1;
			max = Math.max(max, height[h] * width);
		}
		return max;
	}
}
