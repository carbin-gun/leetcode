

/**
 * Distinct Subsequences
 * 
 * Given a string S and a string T, count the number of distinct subsequences of
 * T in S.
 * 
 * A subsequence of a string is a new string which is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (ie, "ACE" is a
 * subsequence of "ABCDE" while "AEC" is not).
 * 
 * Here is an example: S = "rabbbit", T = "rabbit"
 * 
 * Return 3.
 * 
 * http://discuss.leetcode.com/questions/281/distinct-subsequences
 * 
 */

/*
 * The DP solution is quite clear, however, need to make sure the initial case and the 
 * n-1 to n progress. 
 */
public class DistinctSubsequences {
	public int numDistinct(String S, String T) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (S.length() == 0) {
			return 0;
		}
		if (T.length() == 0) {
			return 1;
		}
		if (S.length() == 1 && T.length() == 1) {
			if (S.charAt(0) == T.charAt(0))
				return 1;
			else
				return 0;
		}
		if (S.charAt(0) == T.charAt(0)) {
			return numDistinct(S.substring(1), T.substring(1))
					+ numDistinct(S.substring(1), T); // KEY
		} else {
			return numDistinct(S.substring(1), T); // KEY
		}
	}

	public int numDistinctUpDown(String S, String T) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int dp[][] = new int[S.length() + 1][T.length() + 1];
		dp[0][0] = 1;
		for (int i = 1; i <= T.length(); i++) {
			dp[0][i] = 0;
		}
		for (int i = 1; i <= S.length(); i++) {
			dp[i][0] = 1;
		}
		for (int i = 1; i <= S.length(); i++) {
			for (int j = 1; j <= T.length(); j++) {
				if (S.charAt(i - 1) == T.charAt(j - 1)) {
					//the jth in T should always be included
					dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]; 
				} else {
					//the jth in T should always be included
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[S.length()][T.length()];
	}
}
