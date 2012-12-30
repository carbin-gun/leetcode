package string;

import java.util.ArrayList;

/**
 * Permutations
 * 
 */

public class Permutations {
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (num.length == 0)
			return result;
		boolean isUsed[] = new boolean[num.length];
		ArrayList<Integer> cur = new ArrayList<Integer>();
		for (int i = 0; i < num.length; i++) {
			if (!isUsed[i]) {
				isUsed[i] = true;
				cur.add(num[i]);
				dfs(result, num, isUsed, cur, 1);
				cur.remove(0);
				isUsed[i] = false;
			}
		}
		return result;
	}

	public void dfs(ArrayList<ArrayList<Integer>> result, int[] num,
			boolean[] isUsed, ArrayList<Integer> cur, int length) {
		if (length == num.length) {
			result.add((ArrayList<Integer>) cur.clone());
		} else {
			for (int i = 0; i < num.length; i++) {
				if (!isUsed[i]) {
					isUsed[i] = true;
					cur.add(num[i]);
					dfs(result, num, isUsed, cur, length + 1);
					cur.remove(length);
					isUsed[i] = false;
				}
			}
		}
	}
}
