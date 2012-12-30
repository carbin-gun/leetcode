package unsorted;

import java.util.Stack;
/**
 * Longest Valid Parentheses 
 * Be noticed that you need 1 stack, to record when ( appear, how long 
 * valid before. this is for at last find that still some (( not matched, then 
 * we can use this stack to trace back.
 *
 */

public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
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
