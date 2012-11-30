package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Anagrams
 * sort every string, and hash the sorted string to a hashmap, then get out the 
 * same key strings.
 */

public class Anagrams {
	public ArrayList<String> anagrams(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
		ArrayList<String> result = new ArrayList<String>();
        HashMap<String, ArrayList<String>> hs = new HashMap<String, ArrayList<String>>();
        String newStr = null;
        for(String str : strs) {
            char cs[] = str.toCharArray();
            Arrays.sort(cs);
            newStr = new String(cs);
            if (hs.containsKey(newStr)) {
            	ArrayList<String> al = hs.get(newStr);
            	al.add(str);
                hs.put(newStr, al);
            } else {
            	ArrayList<String> al = new ArrayList<String>();
            	al.add(str);
                hs.put(newStr, al);
            }
        }
        for (String key : hs.keySet()) {
        	if (hs.get(key).size() > 1) {
        		result.addAll(hs.get(key));
        	}
        }
        
        return result;
    }
}
