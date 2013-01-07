import java.util.Arrays;

/**
 * 3Sum Closest 
 * Given an array S of n integers, find three integers in S such
 * that the sum is closest to a given number, target. Return the sum of the
 * three integers. You may assume that each input would have exactly one
 * solution.
 * 
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 */

/*
 * A O(n^2) solution is easy to work out, the clever part is change the f and r, 
 * when the sum - target >= abs(dif) or <= -abs(dif). other wise we update the dif
 */
public class A3SumCloset {
	public int threeSumClosest(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
		int dif = Integer.MAX_VALUE; // be noticed overflow when using the Integer.MAX_VALUE or MIN_VALUE
		Arrays.sort(num);
		for (int i = 0; i < num.length - 2; i++) {
			int f = i + 1;
			int r = num.length - 1;
			while (f < r) {
				int sum = num[i] + num[f] + num[r];
				if (sum - target <= -Math.abs(dif)) {
					f++;
				} else if (sum - target >= Math.abs(dif)) {
					r--;
				} else {
					dif = sum - target;
					if (dif == 0) {
						return target;
					}
				}
			}
		}
        return dif + target;
    }
}
