import java.util.Stack;

/**
 * Largest Rectangle in Histogram 
 * 
 * Given n non-negative integers representing the
 * histogram's bar height where the width of each bar is 1, find the area of
 * largest rectangle in the histogram.
 * 
 * http://discuss.leetcode.com/questions/259/largest-rectangle-in-histogram
 */

/*
 * This is a solution of O(n) runtime. Idea is to keep a stack of increase
 * height index.
 */
public class LargestRectangleinHistogram {
	public int largestRectangleArea(int[] height) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (height.length == 0) {
			return 0;
		}
		Stack<Integer> higher = new Stack<Integer>();
		int max = 0;
		int i = 0;
		while (i < height.length) {
			if (higher.isEmpty() || height[higher.peek()] < height[i]) {
				higher.push(i);
				i++;
			} else {
				int h = higher.pop();
				// I made mistake here, the width should be
				// the current i - 1 as the right, stack top + 1 as left.
				int width = higher.isEmpty() ? i : i - higher.peek() - 1;
				max = Math.max(max, height[h] * width);
			}
		}
		while (!higher.isEmpty()) {
			int h = higher.pop();
			int width = higher.isEmpty() ? i : i - higher.peek() - 1;
			max = Math.max(max, height[h] * width);
		}
		return max;
	}

	/*
	 * Following is a recursive method which is O(n log n) running time.
	 */
	public int largestRectangleAreaNolarge(int[] height) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (height.length == 0)
			return 0;
		return largestRectangleArea(height, 0, height.length - 1);

	}

	public int largestRectangleArea(int[] height, int s, int e) {
		if (s == e) {
			return height[s];
		} else if (s > e) {
			return 0;
		}
		int min = findMin(height, s, e);
		int retangAreaAll = height[min] * (e - s + 1);
		int retangAreaLeft = largestRectangleArea(height, s, min - 1);
		int retangAreaRight = largestRectangleArea(height, min + 1, e);
		int result = Math.max(retangAreaLeft, retangAreaRight);
		result = Math.max(result, retangAreaAll);
		return result;
	}

	public int findMin(int[] height, int s, int e) {
		int index = s;
		int min = height[s];
		while (++s <= e) {
			if (min > height[s]) {
				index = s;
				min = height[s];
			}
		}
		return index;
	}
}
