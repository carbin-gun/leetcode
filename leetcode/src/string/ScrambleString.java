package string;

/**
 * Scramble String
 * it is a dp question, the idea is we need to find a separated point, which left and 
 * right substring are all scramble. 
 * 
 * to pass the large issue, we need to do the small part always first.
 */
public class ScrambleString {
	public boolean isScramble(String s1, String s2) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = s1.length();
		if (n == 1) {
			return s1.equals(s2);
		} else {
			for (int i = 1; i <= n / 2; i++) {
				String a1 = s1.substring(0, i);
				String a2 = s2.substring(0, i);
				String b1 = s1.substring(i);
				String b2 = s2.substring(i);
				String c1 = s1.substring(0, n - i);
				String c2 = s2.substring(0, n - i);
				String d1 = s1.substring(n - i);
				String d2 = s2.substring(n - i);
				if (isScramble(a1, a2) && isScramble(b1, b2)) {
					return true;
				}
				if (isScramble(a1, d2) && isScramble(b1, c2)) {
					return true;
				}
				if (isScramble(d1, a2) && isScramble(c1, b2)) {
					return true;
				}
				if (isScramble(d1, d2) && isScramble(c1, c2)) {
					return true;
				}
			}
			return false;
		}
	}
}
