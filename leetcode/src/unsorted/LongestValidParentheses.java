package unsorted;

import java.util.Stack;
/**
 * Longest Valid Parentheses 
 * Be noticed that you need 2 stack, one for record when ( appear, how long 
 * valid before. this is for at last find that still some (( not matched, then 
 * we can use this stack to trace back.
 *
 */

public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack<Integer> st = new Stack<Integer>();
        Stack<Integer> mask = new Stack<Integer>();
        int cur = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(cur);
                mask.push(-1);
            } else {
                if (!mask.isEmpty() && mask.peek() == -1) {
                    cur++;
                    mask.pop();
                    st.pop();
                } else {
                    max = Math.max(max, cur);
                    cur = 0;
                }
            }
        }
        while (!mask.isEmpty()) {
            mask.pop();
            int tmp = st.pop();
            max = Math.max(max, cur - tmp);
            cur = tmp;
        }
        max = Math.max(max, cur);
        return max * 2;
    }
}
