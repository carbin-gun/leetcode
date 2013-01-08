import java.util.ArrayList;
import java.util.Arrays;

/**
 * Combination Sum 
 * 
 * Given a set of candidate numbers (C) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.
 * 
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note:
 * 
 * All numbers (including target) will be positive integers. Elements in a
 * combination (a1, a2, ... , ak) must be in non-descending order. (ie, a1 ² a2
 * ² ... ² ak). The solution set must not contain duplicate combinations. For
 * example, given candidate set [2, 3, 6, 7] and target 7
 * 
 * A solution set is:
 * 
 * [ [7], [2, 2, 3] ] http://discuss.leetcode.com/questions/61/combination-sum
 * 
 */

/*
 * It is a simple DP ideas.
 */
public class CombinationSum {
	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates,
			int target) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (candidates.length == 0) {
			return new ArrayList<ArrayList<Integer>>();
		}
		Arrays.sort(candidates);
		return combinationSum(candidates, candidates.length - 1, target);
	}

	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates,
			int last, int target) {
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		if (target == 0) {
			ret.add(new ArrayList<Integer>());
			return ret;
		}
		while (last >= 0 && candidates[last] > target) {
			last--;
		}
		if (last < 0) {
			return ret;
		}
		ret.addAll(combinationSum(candidates, last - 1, target));
		for (ArrayList<Integer> ai : combinationSum(candidates, last, target
				- candidates[last])) {
			ai.add(candidates[last]);
			ret.add(ai);
		}
		return ret;
	}
}
