package string;

import java.util.ArrayList;
import java.util.Arrays;

public class PermutationsII {
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
    	// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (num.length == 0)
			return result;
		Arrays.sort(num);
		boolean isUsed[] = new boolean[num.length];
		ArrayList<Integer> cur = new ArrayList<Integer>();
		for (int i = 0; i < num.length;) {
			if (!isUsed[i]) {
				isUsed[i] = true;
				cur.add(num[i]);
				dfs(result, num, isUsed, cur, 1);
				cur.remove(0);
				isUsed[i] = false;
				while (++i < num.length && num[i] == num[i - 1]);
			} else {
    		    i++;   
			}
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public void dfs(ArrayList<ArrayList<Integer>> result, int[] num,
			boolean[] isUsed, ArrayList<Integer> cur, int length) {
		if (length == num.length) {
			result.add((ArrayList<Integer>) cur.clone());
		} else {
			for (int i = 0; i < num.length;) {
				if (!isUsed[i]) {
					isUsed[i] = true;
					cur.add(num[i]);
					dfs(result, num, isUsed, cur, length + 1);
					cur.remove(length);
					isUsed[i] = false;
					while (++i < num.length && num[i] == num[i - 1]);
				} else {
    			    i++;   
				}
			}
		}
	}
}
