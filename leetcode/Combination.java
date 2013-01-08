

import java.util.ArrayList;

/**
 * Combinations It is a DP question.
 * 
 * Given two integers n and k, return all possible combinations of k numbers out
 * of 1 ... n.
 * 
 * For example, If n = 4 and k = 2, a solution is:
 * 
 * [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
 */

/*
 * A DP solution can solve this problem. Consider that we use n as the k element or not.
 */
public class Combination {
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		if (k == 0) {
			ret.add(new ArrayList<Integer>());
			return ret;
		} else if (n == k) {
			ArrayList<Integer> ai = new ArrayList<Integer>();
			for (int i = 1; i <= n; i++) {
				ai.add(i);
			}
			ret.add(ai);
		} else if (n > k) {
			ret.addAll(combine(n - 1, k));
			for (ArrayList<Integer> ai : combine(n - 1, k - 1)) {
				ai.add(n);
				ret.add(ai);
			}
		}
		return ret;
	}
}
