import java.util.ArrayList;

/**
 * Permutations Given a collection of numbers, return all possible permutations.
 * 
 * For example, [1,2,3] have the following permutations: [1,2,3], [1,3,2],
 * [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * 
 * http://discuss.leetcode.com/questions/224/permutations
 */

/*
 * DFS
 */

public class Permutations {
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> cur = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		int[] mask = new int[num.length];
		permute(ret, cur, num, mask);
		return ret;
	}

	public void permute(ArrayList<ArrayList<Integer>> ret,
			ArrayList<Integer> cur, int[] num, int[] mask) {
		if (cur.size() == num.length) {
			ret.add((ArrayList<Integer>) cur.clone());
		} else {
			for (int i = 0; i < num.length; i++) {
				if (mask[i] == 0) {
					mask[i] = 1;
					cur.add(num[i]);
					permute(ret, cur, num, mask);
					cur.remove(cur.size() - 1);
					mask[i] = 0;
				}
			}
		}
	}
}
