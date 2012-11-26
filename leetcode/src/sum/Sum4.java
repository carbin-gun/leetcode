package sum;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Sum4 {
	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
		HashSet<ArrayList<Integer>> hs = new HashSet<ArrayList<Integer>>();
		if (num.length < 4) {
			return new ArrayList<ArrayList<Integer>>(hs);
		}
		Arrays.sort(num);
        for (int i = 0; i < num.length - 3; i++) {
        	ArrayList<ArrayList<Integer>> al = threeSum(num, target - num[i], i + 1);
        	if (al.size() != 0) {
        		for(ArrayList<Integer> ai : al) {
        			ai.add(num[i]);
        			Collections.sort(ai);
        			hs.add(ai);
        		}
        	}
        }
        return new ArrayList<ArrayList<Integer>>(hs);
    }
	
	public ArrayList<ArrayList<Integer>> threeSum(int arr[], int target, int start) {
		HashSet<ArrayList<Integer>> re = new HashSet<ArrayList<Integer>>();
		for (int i = start; i < arr.length - 2; i++) {
			int f = i + 1;
			int r = arr.length - 1;
			while (f < r) {
				int sum = arr[i] + arr[f] + arr[r];
				if (sum > target) {
					r--;
				} else if (sum < target) {
					f++;
				} else {
					ArrayList<Integer> al = new ArrayList<Integer>();
					al.add(arr[i]);
					al.add(arr[f]);
					al.add(arr[r]);
					re.add(al);
					f++;
					r--;
				}
			}
		}
		return new ArrayList<ArrayList<Integer>>(re);
	}
	
	public static void main(String argv[]) {
		int num[] = {1,0,-1,0,-2,2};
		System.out.println(new Sum4().fourSum(num, 0));
	}
}
