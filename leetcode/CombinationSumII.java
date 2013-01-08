

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Combination Sum II
 * 
 * Given a collection of candidate numbers (C) and a target number (T), find all
 * unique combinations in C where the candidate numbers sums to T.
 * 
 * Each number in C may only be used once in the combination.
 * 
 * Note: All numbers (including target) will be positive integers. Elements in a
 * combination (ie, a1 ≤ a2 ≤ ... ≤ ak). must be in non-descending order. (ie,
 * a1 ≤ a2 ≤ ... ≤ ak). The solution set must not contain duplicate
 * combinations. For example, given candidate set 10,1,2,7,6,1,5 and target 8, A
 * solution set is: [1, 7] [1, 2, 5] [2, 6] [1, 1, 6]
 * 
 * http://leetcode.com/questions/218/combination-sum-ii
 */

/*
 * Sample dp solution make it works, one thing need to take care is the dup result. So 
 * we using hashset instead of arraylist. it is different with the sumI.
 */
public class CombinationSumII {
	public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates,
			int target) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (candidates.length == 0) {
			return new ArrayList<ArrayList<Integer>>();
		}
		Arrays.sort(candidates);
		return new ArrayList<ArrayList<Integer>>(combinationSum(candidates,
				candidates.length - 1, target));
	}

	public HashSet<ArrayList<Integer>> combinationSum(int[] candidates,
			int last, int target) {
		HashSet<ArrayList<Integer>> ret = new HashSet<ArrayList<Integer>>();
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
		for (ArrayList<Integer> ai : combinationSum(candidates, last - 1,
				target - candidates[last])) {
			ai.add(candidates[last]);
			ret.add(ai);
		}
		return ret;
	}
}
