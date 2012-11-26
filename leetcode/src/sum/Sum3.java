package sum;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

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
