package unsorted;

import java.util.Stack;

/**
 * Trapping Rain Water
 * http://discuss.leetcode.com/questions/220/trapping-rain-water
 *
 */
public class TrappingRainWater {
	public int trap(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int re = 0;
        Stack<Integer> s = new Stack<Integer>();
        int index = 0;
        while (index < A.length) {
            if (s.isEmpty() || A[s.peek()] > A[index]) {
        		s.push(index);
        		index++;
        	} else {
        		int bottom = s.pop();
        		if (!s.isEmpty()) {
        			int left = s.peek();
        			int right = index;
        			re += (right - left - 1) * (Math.min(A[left], A[right]) - A[bottom]);
        		}
        	}
        }
        return re;
    }
	
	public static void main(String argv[]) {
		TrappingRainWater trw = new TrappingRainWater();
		int A[] = {2, 1, 0, 2};
		trw.trap(A);
		
	}
}
