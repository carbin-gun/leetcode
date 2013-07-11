

/**
 * Unique Binary Search Trees 
 * http://discuss.leetcode.com/questions/270/unique-binary-search-trees
 */

public class UniqueBinarySearchTrees {
	public int numTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] re = new int[n + 1];
        re[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
        		re[i] += re[j - 1] * re [i - j];
        	}
        }
        return re[n];
    }
}
