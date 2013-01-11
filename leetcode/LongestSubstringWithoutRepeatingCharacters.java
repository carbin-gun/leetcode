/**
 * Longest Substring Without Repeating Characters
 * 
 * Given a string, find the length of the longest substring without repeating
 * characters.
 * 
 * For example, the longest substring without repeating letters for "abcabcbb"
 * is "abc", which the length is 3.
 * 
 * For "bbbbb" the longest substring is "b", with the length of 1.
 * 
 * http://discuss.leetcode.com/questions/154/longest-substring-without-repeating-characters
 * 
 */
public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
         if (s == null || s.equals("")) {
     		return 0;
     	}
     	int max = 0;
     	int start = 0, end = 0;
     	boolean[] mask = new boolean[256];
     	while (end < s.length()) {
     		if (mask[(int) s.charAt(end)]) {
     			mask[(int) s.charAt(start)] = false;
     			start++;
     		} else {
     			mask[(int) s.charAt(end)] = true;
     			max = Math.max(max, end - start + 1);
     			end++;
     		}
     	}
     	return max;
    }
}
