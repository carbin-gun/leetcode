package string;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Substring with Concatenation of All Words
 * 
 */
public class SubstringWithConcatenationOfAllWords {
	public ArrayList<Integer> findSubstring(String S, String[] L) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> re = new ArrayList<Integer>();
		if (L.length == 0 || S.length() < L.length * L[0].length()) {
			return re;
		}
		HashMap<String, Integer> need = new HashMap<String, Integer>();
		for (int i = 0; i < L.length; i++) {
			if (need.containsKey(L[i])) {
				need.put(L[i], need.get(L[i]) + 1);
			} else {
				need.put(L[i], 1);
			}
		}
		ArrayList<String> l = new ArrayList<String>(need.keySet());
		int[] mask = new int[S.length()];
		int wordLength = L[0].length();
		for (int i = 0; i < S.length(); i++) {
			mask[i] = -1;
			for (int j = 0; j < l.size(); j++) {
				if (S.substring(i).startsWith(l.get(j))) {
					mask[i] = j;
					break;
				}
			}
		}

		for (int i = 0; i < wordLength; i++) {
			int start = i;
			int end = i;
			HashMap<String, Integer> isFound = new HashMap<String, Integer>();
			int counter = L.length;
			while (end < mask.length || counter == 0) {
				if (counter != 0 && mask[end] == -1) {
					counter = L.length;
					end += wordLength;
					start = end;
					isFound.clear();
				} else if (counter != 0) {
					String cur = l.get(mask[end]);
					if (!isFound.containsKey(cur)) {
						isFound.put(cur, 1);
						counter--;
						end += wordLength;
					} else if (isFound.get(cur) < need.get(cur)) {
						isFound.put(cur, isFound.get(cur) + 1);
						counter--;
						end += wordLength;
					} else {
						while (l.get(mask[start]) != cur) {
							isFound.put(l.get(mask[start]),
									isFound.get(l.get(mask[start])) - 1);
							counter++;
							start += wordLength;
						}
						start += wordLength;
						isFound.put(cur, isFound.get(cur) - 1);
						counter++;
					}
				} else {
					re.add(start);
					isFound.put(l.get(mask[start]),
							isFound.get(l.get(mask[start])) - 1);
					counter++;
					start += wordLength;
				}
			}
		}
		return re;
	}

	public static void main(String argv[]) {
		SubstringWithConcatenationOfAllWords s = new SubstringWithConcatenationOfAllWords();
		String str[] = { "a", "b" };
		System.out.println(s.findSubstring("abababab", str).toString());
	}
}
