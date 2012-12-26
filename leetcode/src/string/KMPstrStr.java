package string;

public class KMPstrStr {
	public class Solution {
		public String strStr(String haystack, String needle) {
			// Start typing your Java solution below
			// DO NOT write main() function
			if (needle == null || needle == "")
				return haystack;
			if (haystack == "")
				return null;
			if (haystack.length() < needle.length())
				return null;
			int prefix[] = preFix(needle);
			int i = 0;
			int j = 0;
			int firstPosition = -1;
			while (i <= haystack.length()) {
				if (j == needle.length()) {
					firstPosition = i - j;
					break;
				} else if (i == haystack.length()) {
					break;
				} else if (haystack.charAt(i) == needle.charAt(j)) {
					i++;
					j++;
				} else {
					if (prefix[j] == -1) {
						i++;
						j = 0;
					} else {
						j = prefix[j];
					}
				}
			}
			if (firstPosition == -1) {
				return null;
			} else {
				return haystack.substring(firstPosition);
			}
		}

		public int[] preFix(String needle) {
			int[] a = new int[needle.length()];
			a[0] = -1;
			if (needle.length() == 1) {
				return a;
			}
			a[1] = 0;
			int i = 0;
			int j = 1;
			while (j < needle.length() - 1) {
				if (needle.charAt(i) == needle.charAt(j)) {
					a[j + 1] = a[j] + 1;
					j++;
					i++;
				} else {
					a[j + 1] = 0;
					j++;
					i = 0;
				}
			}
			return a;
		}
	}
}
