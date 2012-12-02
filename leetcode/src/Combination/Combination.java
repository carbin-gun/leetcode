package Combination;

import java.util.ArrayList;

/**
 * Combinations
 * It is a DP question.
 */
public class Combination {
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>> ();
        if (n < k) {
            return re;
        }
        if (k == 1) {
            for(int i = 1; i <= n; i++) {
                ArrayList<Integer> ai = new ArrayList<Integer>();
                ai.add(i);
                re.add(ai);
            }
        } else {
            re.addAll(combine(n - 1, k));
            ArrayList<ArrayList<Integer>> tmp = combine(n - 1, k - 1);
            for (ArrayList<Integer> ai : tmp) {
                ai.add(n);
                re.add(ai);
            }
        }
        return re;
    }
}
