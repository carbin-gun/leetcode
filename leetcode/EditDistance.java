/**
 * Edit Distance
 * 
 * Given two words word1 and word2, find the minimum number of steps required to
 * convert word1 to word2. (each operation is counted as 1 step.)
 * 
 * You have the following 3 operations permitted on a word:
 * 
 * a) Insert a character b) Delete a character c) Replace a character
 * http://leetcode.com/questions/248/edit-distance
 * 
 */
/*
 * DP solution
 */
public class EditDistance {
	public int minDistance(String word1, String word2) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int dp[][] = new int[word1.length() + 1][word2.length() + 1];
		dp[0][0] = 0;
		for (int i = 1; i <= word1.length(); i++) {
			dp[i][0] = i;
		}
		for (int i = 1; i <= word2.length(); i++) {
			dp[0][i] = i;
		}
		for (int i = 1; i <= word1.length(); i++) {
			for (int j = 1; j <= word2.length(); j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					int tmp = Math.min(dp[i - 1][j], dp[i][j - 1]);
					dp[i][j] = Math.min(tmp, dp[i - 1][j - 1]) + 1;
				}
			}
		}
		return dp[word1.length()][word2.length()];
	}
}
