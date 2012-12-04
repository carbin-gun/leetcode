package string;
/**
 * Edit Distance
 * Be careful that the initial value of the DP matrix;
 * 
 */
public class EditDistance {
	public int minDistance(String word1, String word2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (word1.length() == 0) 
            return word2.length();
        if (word2.length() == 0)
            return word1.length();
        int mask[][] = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++)
            mask[i][0] = i;
        for (int j = 0; j <= word2.length(); j++)
            mask[0][j] = j;
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    mask[i][j] = mask[i - 1][j - 1];
                } else {
                    int tmp = mask[i - 1][j - 1] < mask[i - 1][j] ? mask[i - 1][j - 1] : mask[i - 1][j];
                    mask[i][j] = (tmp < mask[i][j - 1] ? tmp : mask[i][j - 1]) + 1;
                }      
            }
        }
        return mask[word1.length()][word2.length()];
    }
}
