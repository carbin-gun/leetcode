

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Anagrams Given an array of strings, return all groups of strings that are
 * anagrams.
 * 
 * Note: All inputs will be in lower-case.
 */

/*
 * Sort every string by alph order, then keep the hashmap of sorted strings.
 */

public class Anagrams {
	public ArrayList<String> anagrams(String[] strs) {
		// Start typing your Java solution below
		// DO NOT write main() function
		HashMap<String, ArrayList<String>> hash = new HashMap<String, ArrayList<String>>();
		ArrayList<String> ret = new ArrayList<String>();
		if (strs.length < 2) {
			return ret;
		}
		for (int i = 0; i < strs.length; i++) {
			char[] chars = strs[i].toCharArray();
			Arrays.sort(chars);
			String cur = new String(chars);
			if (hash.containsKey(cur)) {
				hash.get(cur).add(strs[i]);
			} else {
				ArrayList<String> al = new ArrayList<String>();
				al.add(strs[i]);
				hash.put(cur, al);
			}
		}
		for (String s : hash.keySet()) {
			if (hash.get(s).size() > 1) {
				ret.addAll(hash.get(s));
			}
		}
		return ret;
	}
}
