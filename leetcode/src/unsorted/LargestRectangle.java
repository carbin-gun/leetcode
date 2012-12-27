package unsorted;

import java.util.Stack;

/**
 * Largest Rectangle in Histogram With first algorithm I worked out, it can not
 * pass large data.
 * 
 */

public class LargestRectangle {
	public int largestRectangleArea(int[] height) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int i = 0;
		int max = 0;
		Stack<Integer> s = new Stack<Integer>();
		while (i < height.length) {
			if (s.empty() || height[s.peek()] < height[i]) {
				s.push(i);
			} else if (height[s.peek()] >= height[i]) {
				while (!s.empty() && height[s.peek()] >= height[i]) {
					int index = s.pop();
					if (!s.empty()) {
						max = Math.max(max, height[index] * (i - s.peek() - 1));
					} else {
						max = Math.max(max, height[index] * (i));
					}
				}
				s.push(i);
			}
			i++;
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

	public static void main(String argv[]) {
		LargestRectangle lr = new LargestRectangle();
		int a[] = { 0 };
		lr.largestRectangleArea(a);
		String s = "a";
		s = s + 't';
	}
}
