package sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Combination Sum II
 * 1 D DP
 */

public class CombinationSumII {
	public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (num == null || num.length == 0) {
            return new ArrayList<ArrayList<Integer>>();
        }
        Arrays.sort(num);
        return combinationSum2(num, num.length - 1, target);
    }
    
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int end, int target) {
        HashSet<ArrayList<Integer>> re = new HashSet<ArrayList<Integer>>();
        if (target < 0) {
            return new ArrayList<ArrayList<Integer>>(re);
        } else if (target == 0) {
            re.add(new ArrayList<Integer>());
            return new ArrayList<ArrayList<Integer>>(re);
        }
        while (end >= 0 && num[end] > target) {
            end--;
        }
        if (end < 0) {
            return new ArrayList<ArrayList<Integer>>(re);
        }
        re.addAll(combinationSum2(num, end - 1, target));
        ArrayList<ArrayList<Integer>> tmp = combinationSum2(num, end - 1, target - num[end]);
        for (ArrayList<Integer> co : tmp) {
            co.add(num[end]);
            re.add(co);
        }
        return new ArrayList<ArrayList<Integer>>(re);
    }
}
