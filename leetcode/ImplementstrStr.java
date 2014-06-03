/**
 * Implement strStr() 
 * 
 * The strstr() function shall locate the first occurrence in
 * the string pointed to by s1 of the sequence of bytes (excluding the
 * terminating null byte) in the string pointed to by s2. Implement strStr()
 * function.
 * 
 * Return a pointer to the first occurrence of needle in haystack, or null if
 * needle is not part of haystack.
 * 
 * Do not use any system library functions such as strlen.
 * 
 */

/*
 * The solution is using KMP to catch the first substring.
 */
public class ImplementstrStr {
	public String strStr(String haystack, String needle) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (needle.equals("")) {
			return haystack;
		}
		int[] prefix = prefix(needle.toCharArray());
		int index = 0;
		int pointer = 0;
		while (index < haystack.length()) {
			if (pointer == needle.length()) {
				return haystack.substring(index - pointer);
			} else {
				if (haystack.charAt(index) == needle.charAt(pointer)) {
					index++;
					pointer++;
				} else {
					if (prefix[pointer] == -1) {
						index++;
						pointer = 0;
					} else {
						pointer = prefix[pointer];
					}
				}
			}
		}
		if (pointer == needle.length()) {
			return haystack.substring(haystack.length() - pointer);
		}
		return null;
	}

	/*
	 * To generate the prefix array
	 */
	public int[] prefix(char[] pattern) {
	    int prefix[] = new int[pattern.length];
            prefix[0] = -1;
            int j = 0;
            for (int i = 1; i < pattern.length - 1;) {
                if (pattern[i] == pattern[j]) {
                    j++;
                    prefix[i + 1] = j;
                    i++;
                } else if (j != 0) {
                    j = 0;
                } else {
                    prefix[i + 1] = 0;
                    i++;
                }
            }
            return prefix;
	}
}
