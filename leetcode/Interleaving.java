/**
 * Interleaving String 
 * 
 * Given s1, s2, s3, find whether s3 is formed by the
 * interleaving of s1 and s2.
 * 
 * For example, Given: s1 = "aabcc", s2 = "dbbca",
 * 
 * When s3 = "aadbbcbcac", return true. When s3 = "aadbbbaccc", return false.
 * 
 */
/*
 * Typical DP solution
 */
public class Interleaving {
	public boolean isInterleave(String s1, String s2, String s3) {
		// Start typing your C/C++ solution below
		// DO NOT write int main() function
		if (s3.length() != s1.length() + s2.length()) {
			return false;
		}
		boolean isInterleaving[][] = new boolean[s1.length() + 1][s2.length() + 1];
		isInterleaving[0][0] = true;
		for (int i = 1; i <= s1.length(); i++) {
			isInterleaving[i][0] = (s3.charAt(i - 1) == s1.charAt(i - 1) && isInterleaving[i - 1][0]);
		}
		for (int j = 1; j <= s2.length(); j++) {
			isInterleaving[0][j] = (s3.charAt(j - 1) == s2.charAt(j - 1) && isInterleaving[0][j - 1]);
		}
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (isInterleaving[i - 1][j] == false
						&& isInterleaving[i][j - 1] == false) {
					isInterleaving[i][j] = false;
				} else if (isInterleaving[i - 1][j]) {
					isInterleaving[i][j] = (s3.charAt(i + j - 1) == s1
							.charAt(i - 1));
				} else if (isInterleaving[i][j - 1]) {
					isInterleaving[i][j] = (s3.charAt(i + j - 1) == s2
							.charAt(j - 1));
				}
			}
		}
		return isInterleaving[s1.length()][s2.length()];
	}
}
