package sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * 3Sum
 * The algorithm is to sort the array first, and then start from the the number which 
 * is no larger than 0, then find then match from the number larger than the source 
 * number, it can be done by o(n^2) time, which is move from either side at a time.
 * It can prove that all the result can be found correctly.
 *
 */

public class Sum3 {
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
		HashSet<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();
        if (num.length == 0) 
            return new ArrayList<ArrayList<Integer>>(result);
        Arrays.sort(num);
        for(int i=0; i < num.length - 2; i++) {
            if(num[i] > 0)
                break;
            int f = i + 1;
            int r = num.length - 1;
            while (f < r) {
                int sum = num[i] + num[f] + num[r];
                if (sum == 0) {
                    ArrayList<Integer> t = new ArrayList<Integer>();
                    t.add(num[i]);
                    t.add(num[f]);
                    t.add(num[r]);
                    result.add(t);
                    f++;
                    r--;
                } else if (sum < 0) {
                    f++;
                } else {
                    r--;
                }
            }
        }
        return new ArrayList<ArrayList<Integer>>(result);
    }
}
