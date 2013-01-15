import java.util.HashMap;

/**
 * Minimum Window Substring
 * 
 * Given a set T of characters and a string S, find the minimum window in S
 * which will contain all the characters in T in complexity O(n).
 * 
 * eg, S = "ADOBECODEBANC" T = "ABC"
 * 
 * Minimum window is "BANC".
 * 
 * Note: If there is no such window in S that covers all characters in T, return
 * the emtpy string "".
 * 
 * If there are multiple such windows, you are guaranteed that there will always
 * be only one unique minimum window in S.
 * 
 * http://discuss.leetcode.com/questions/97/minimum-window-substring
 */

/*
 * Optimize end and start
 */
public class MinimumWindowSubstring {
	public String minWindow(String S, String T) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (T.equals("")) {
			return "";
		}
		if (S.length() < T.length()) {
			return "";
		}
		HashMap<Character, Integer> required = new HashMap<Character, Integer>();
		for (char c : T.toCharArray()) {
			if (required.containsKey(c)) {
				required.put(c, required.get(c) + 1);
			} else {
				required.put(c, 1);
			}
		}
		int min = Integer.MAX_VALUE;
		int minStart = -1;
		int count = T.length();
		int start = 0, end = 0;
		while (end < S.length() || count == 0) {
			if (count > 0) {
				char c = S.charAt(end);
				if (required.containsKey(c)) {
					if (required.get(c) > 0) {
						count--;
					}
					required.put(c, required.get(c) - 1);
				}
				end++;
			} else {
				if (end - start < min) {
					min = end - start;
					minStart = start;
				}
				char c = S.charAt(start);
				if (required.containsKey(c)) {
					if (required.get(c) == 0) {
						count++;
					}
					required.put(c, required.get(c) + 1);
				}
				start++;
			}
		}
		if (minStart == -1) {
			return "";
		}
		return S.substring(minStart, minStart + min);
	}
}
