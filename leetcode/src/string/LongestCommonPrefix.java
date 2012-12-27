package string;

/**
 * Longest Common Prefix
 * 
 */
public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		// Start typing your Java solution below
		// DO NOT write main() function
		String common = "";
		if (strs.length == 0)
			return common;
		common = strs[0];
		for (int i = 1; i < strs.length; i++) {
			int j = 0;
			while (j < common.length() && j < strs[i].length()) {
				if (common.charAt(j) != strs[i].charAt(j)) {
					break;
				}
				j++;
			}
			common = common.substring(0, j);
			if (common.length() == 0) {
				return "";
			}
		}
		return common;
	}
}
