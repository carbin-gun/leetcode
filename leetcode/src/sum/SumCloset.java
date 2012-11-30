package sum;

import java.util.Arrays;

/**
 * Similar like the the 3 sum with target, keep to trace a min as a distance from the 
 * target. when ever it falls into the min distance update the min.
 * 
 */
public class SumCloset {
	public int threeSumClosest(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
		int min = Integer.MAX_VALUE; // when you are using this, take care that it could be out of boundary of integer
		Arrays.sort(num);
		for (int i = 0; i < num.length - 2; i++) {
			int f = i + 1;
			int r = num.length - 1;
			while (f < r) {
				int sum = num[i] + num[f] + num[r];
				if (min != Integer.MAX_VALUE && sum <= target - Math.abs(min)) {
					f++;
				} else if (min != Integer.MAX_VALUE && sum >= target + Math.abs(min)) {
					r--;
				} else {
					min = sum - target;
					if (min == 0) {
						return target;
					}
				}
			}
		}
        return min + target;
    }
	
	public static void main(String argv[]) {
		SumCloset sc = new SumCloset();
		int num[] = {0,0,0};
		System.out.println(sc.threeSumClosest(num, 1));
	}
}
