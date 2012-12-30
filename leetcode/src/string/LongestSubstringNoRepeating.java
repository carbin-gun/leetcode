package string;

import java.util.HashMap;

/**
 * Longest Substring Without Repeating Characters
 * need take care about the logic, that need clear all the hash when find a existed char,
 * and re-construct the hash again.
 * The previous method is not good enough, we can redo it in a better way, see new mothod.
 * 
 *
 */
public class LongestSubstringNoRepeating {
	public int lengthOfLongestSubstring(String s) {
		int max = Integer.MIN_VALUE;
		int start = 0;
		int end = 0;
		boolean mask[] = new boolean[256];
		while (end < s.length()) {
			int val = (int) s.charAt(end);
			if (mask[val] == false) {
				mask[val] = true;
				end++;
			} else {
				max = Math.max(max, end - start);
				mask[(int) s.charAt(start)] = false;
				start++;
			}
		}
		max = Math.max(max, end - start);
		return max;
	}
	
	public int lengthOfLongestSubstringNotGood(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int max = Integer.MIN_VALUE;
        int current = 0;
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if(!hm.containsKey(s.charAt(i))) {
                hm.put(s.charAt(i), i);
                current++;
            } else {
                max = Math.max(max, current);
                int last = hm.get(s.charAt(i));
                current = i - last;
                hm.clear();
                for (int j = last; j <= i; j ++) {
                    hm.put(s.charAt(j), j);
                }
                
            }
        }
        max = Math.max(max, current);
        return max;
    }
}
