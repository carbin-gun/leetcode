package unsorted;

import java.util.Stack;

/**
 * Maximal Rectangle
 * My mathod is O(n^2) but still not pass the large data test. wired. 
 *
 */
public class MaximalRectangle {
	
	public int maximalRectangle(char[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (matrix.length == 0) {
        	return 0;
        } else if (matrix[0].length == 0) {
        	return 0;
        }
        int max = Integer.MIN_VALUE;
        int[] height = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
        	for (int j = 0; j < matrix[0].length; j++) {
        		if (matrix[i][j] == '1') {
        			height[j]++;
        		} else {
        			height[j] = 0;
        		}
        	}
        	max = Math.max(max, longestRectangle(height));
        }
        return max;
    }
	
	public int longestRectangle(int[] height) {
		if (height.length == 0) {
			return 0;
		} else if (height.length == 1) {
			return height[0];
		}
		int max = Integer.MIN_VALUE;
		Stack<Integer> s = new Stack<Integer>();
		int i = 0;
		for (i = 0; i < height.length; i++) {
			if (s.empty() || height[s.peek()] < height[i]) {
				s.push(i);
			} else {
				while (!s.empty() && height[s.peek()] >= height[i]) {
					int index = s.pop();
					if (s.empty()) {
						max = Math.max(max, height[index] * i);
					} else {
						max = Math.max(max, height[index] * (i - s.peek() - 1));
					}
				}
				s.push(i);
			}
		}
		while (!s.empty()) {
			int cur = s.pop();
			if (!s.empty()) {
				max = Math.max(max, height[cur] * (i - s.peek() - 1));
			} else {
				max = Math.max(max, height[cur] * (i));
			}
		}
		return max;
	}
}
