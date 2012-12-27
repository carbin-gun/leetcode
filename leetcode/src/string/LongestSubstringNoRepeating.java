package string;

import java.util.HashMap;

/**
 * Longest Substring Without Repeating Characters
 * need take care about the logic, that need clear all the hash when find a existed char,
 * and re-construct the hash again.
 *
 */
public class LongestSubstringNoRepeating {
	public int lengthOfLongestSubstring(String s) {
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
