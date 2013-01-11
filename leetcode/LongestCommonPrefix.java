/**
 * Longest Common Prefix 
 * 
 * Write a function to find the longest common prefix
 * string amongst an array of strings.
 * 
 * http://discuss.leetcode.com/questions/196/longest-common-prefix
 */

/*
 * Keep record a length of common prefix.
 */
public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (strs.length == 0) {
			return "";
		}
		String base = strs[0];
		int length = base.length();
		for (int i = 1; i < strs.length; i++) {
			length = Math.min(length, strs[i].length());
			for (int j = 0; j < length; j++) {
				if (base.charAt(j) != strs[i].charAt(j)) {
					length = j; // it should set to j, not j - 1
					break;
				}
			}
		}
		return base.substring(0, length);
	}
}
