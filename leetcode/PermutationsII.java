import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a collection of numbers that might contain duplicates, return all
 * possible unique permutations.
 * 
 * For example, [1,1,2] have the following unique permutations: [1,1,2],
 * [1,2,1], and [2,1,1].
 * 
 * http://discuss.leetcode.com/questions/225/permutations-ii
 */

/*
 * DFS solution
 */
public class PermutationsII {
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function

		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		if (num.length == 0) {
			return ret;
		}
		ArrayList<Integer> cur = new ArrayList<Integer>();
		Arrays.sort(num);
		int[] mask = new int[num.length];
		dfs(ret, cur, num, mask);
		return ret;
	}

	@SuppressWarnings("unchecked")
	public void dfs(ArrayList<ArrayList<Integer>> ret, ArrayList<Integer> cur,
			int[] num, int[] mask) {
		if (cur.size() == num.length) {
			ret.add((ArrayList<Integer>) cur.clone());
			return;
		}
		for (int i = 0; i < mask.length; i++) {
			if (mask[i] == 0) {
				mask[i] = 1;
				cur.add(num[i]);
				dfs(ret, cur, num, mask);
				cur.remove(cur.size() - 1);
				mask[i] = 0;
				while (i < mask.length - 1 && num[i] == num[i + 1])
					i++;
			}
		}
	}
}
