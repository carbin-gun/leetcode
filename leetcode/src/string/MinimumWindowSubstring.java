package string;

import java.util.HashMap;

/**
 * Minimum Window Substring
 * the main idea is to optimize end, and start pointer. keep two hashmap
 * 
 */
public class MinimumWindowSubstring {
	public String minWindow(String S, String T) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (S == "" || T == "") {
			return "";
		}

		HashMap<Character, Integer> need = new HashMap<Character, Integer>();
		for (char c : T.toCharArray()) {
			if (need.containsKey(c)) {
				need.put(c, need.get(c) + 1);
			} else {
				need.put(c, 1);
			}
		}
		HashMap<Character, Integer> hasFound = new HashMap<Character, Integer>();
		int start = 0;
		int end = 0;
		int optStart = -1;
		int optEnd = -1;
		int counter = T.length();
		while (end < S.length() || counter == 0) {
			if (counter > 0) {
				char c = S.charAt(end);
				if (need.containsKey(c)) {
					if (hasFound.containsKey(c)) {
						int found = hasFound.get(c);
						if (found < need.get(c)) {
							counter--;
						}
						hasFound.put(c, found + 1);
					} else {
						counter--;
						hasFound.put(c, 1);
					}
				}
				end++;
			} else {
				if (optStart == -1 || optEnd - optStart > end - start) {
					optStart = start;
					optEnd = end;
				}
				char c = S.charAt(start);
				start++;
				if (need.containsKey(c)) {
					int found = hasFound.get(c);
					if (found == need.get(c)) {
						counter++;
					}
					hasFound.put(c, found - 1);
				}
			}
		}
		if (optStart == -1) {
			return "";
		} else {
			return S.substring(optStart, optEnd);
		}
	}

	public static void main(String argv[]) {
		MinimumWindowSubstring mws = new MinimumWindowSubstring();
		System.out.println(mws.minWindow("acbbaca", "aba"));

	}
}
