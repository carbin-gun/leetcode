package string;
/**
 * Distinct Subsequences
 * I massed this up, and did not know how to solve this issue in DP. 
 * This is actually very easy. Here I list a method of recursive and 
 * straight forward.
 *
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
        if(S.length() == 1 && T.length() == 1){
            if(S.charAt(0) == T.charAt(0)) return 1;
            else return 0;
        }
        if (S.charAt(0) == T.charAt(0)) {
            return numDistinct(S.substring(1), T.substring(1)) + numDistinct(S.substring(1), T);
        } else {
            return numDistinct(S.substring(1), T);
        }
    }
	
	public int numDistinctNonRecur(String S, String T) {
		if (T.length() == 0) {
			return 1;
		}
		if (S.length() == 0) {
			return 0;
		} 
		int[][] arr = new int[S.length() + 1][T.length() + 1];
		for (int j = 0; j < T.length() + 1; j++) {
    		arr[0][j] = 0;
		}
		for (int i = 0; i < S.length() + 1; i++) {
			arr[i][0] = 1;
		}
		for (int i = 1; i < S.length() + 1; i++) {
			for (int j = 1; j < T.length() + 1; j++) {
				if (S.charAt(i - 1) == T.charAt(j - 1)) {
					arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
				} else {
					arr[i][j] = arr[i - 1][j];
				}
			}
		}
		return arr[S.length()][T.length()];
	}
}
