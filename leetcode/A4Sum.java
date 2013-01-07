import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * 4Sum Given an array S of n integers, are there elements a, b, c, and d in S
 * such that a + b + c + d = target? Find all unique quadruplets in the array
 * which gives the sum of target.
 * 
 * Note: Elements in a quadruplet (a,b,c,d) must be in non-descending order.
 * (ie, a ² b ² c ² d) The solution set must not contain duplicate quadruplets.
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * 
 * A solution set is: (-1, 0, 0, 1) (-2, -1, 1, 2) (-2, 0, 0, 2)
 * http://discuss.leetcode.com/questions/199/4sum
 */

/*
 * This is a O(n ^ 3) solution, however there is a O(n^2 log n) method is existed, 
 * It need more space to record the rest information.
 */
public class A4Sum {
	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		HashSet<ArrayList<Integer>> ret = new HashSet<ArrayList<Integer>>();
		if (num.length < 4) {
			return new ArrayList<ArrayList<Integer>>(ret);
		}
		Arrays.sort(num);
		int f = num.length - 1;
		while (f > 2) {
			ArrayList<ArrayList<Integer>> pairs = threeSum(num, f, target
					- num[f]);
			for (ArrayList<Integer> pair : pairs) {
				pair.add(num[f]);
				ret.add(pair);
			}
			f--;
		}
		return new ArrayList<ArrayList<Integer>>(ret);
	}

	public ArrayList<ArrayList<Integer>> threeSum(int[] num, int end, int target) {
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		int f = 0;
		while (f < end - 2) {
			int s = f + 1;
			int e = end - 1;
			while (s < e) {
				int sum = num[f] + num[s] + num[e];
				if (target < sum) {
					e--;
				} else if (target > sum) {
					s++;
				} else {
					ArrayList<Integer> pair = new ArrayList<Integer>();
					pair.add(num[f]);
					pair.add(num[s]);
					pair.add(num[e]);
					ret.add(pair);
					s++;
					e--;
				}
			}
			f++;
		}
		return ret;
	}

	public static void main(String argv[]) {
		int num[] = { 1, 0, -1, 0, -2, 2 };
		System.out.println(new A4Sum().fourSum(num, 0));
	}
}
