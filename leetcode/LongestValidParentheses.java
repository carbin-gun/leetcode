import java.util.Stack;

/**
 * Longest Valid Parentheses
 * 
 * Given a string containing just the characters '(' and ')', find the length of
 * the longest valid (well-formed) parentheses substring.
 * 
 * For "(()", the longest valid parentheses substring is "()", which has length
 * = 2.
 * 
 * Another example is ")()())", where the longest valid parentheses substring is
 * "()()", which has length = 4.
 * 
 * http://discuss.leetcode.com/questions/212/longest-valid-parentheses
 * 
 */

/*
 * Two solution is provided here, be noticed that two ways the parentheses get invalid, 
 * not matched ( and not matched );
 */
public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int max = 0;
		int start = -1;
		Stack<Integer> position = new Stack<Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				position.push(i);
			} else {
				if (position.isEmpty()) {
					start = i;
				} else {
					position.pop();
					int curMax = 0;
					if (position.isEmpty()) {
						curMax = i - start;
					} else {
						curMax = i - position.peek();
					}
					max = Math.max(max, curMax);
				}
			}
		}
		return max;
	}

	public int longestValidParentheses2(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		Stack<Integer> st = new Stack<Integer>();
		int cur = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				st.push(cur);
			} else {
				if (!st.isEmpty()) {
					cur++;
					st.pop();
				} else {
					max = Math.max(max, cur);
					cur = 0;
				}
			}
		}
		while (!st.isEmpty()) {
			int tmp = st.pop();
			max = Math.max(max, cur - tmp);
			cur = tmp;
		}
		max = Math.max(max, cur);
		return max * 2;
	}
}
