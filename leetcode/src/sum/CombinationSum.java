package sum;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Combination Sum
 *
 */
public class CombinationSum {
	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(candidates);
        return combination(candidates, candidates.length - 1, target);
    }
    
    public ArrayList<ArrayList<Integer>> combination(int [] candidates, int last, int target) {
        ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
        if (target == 0) {
            re.add(new ArrayList<Integer>());
            return re;
        } else if (target < 0) 
            return re;
        
        while (last >= 0 && candidates[last] > target) {
            last--;
        }
        
        if (last < 0) {
            return re;
        }
        

        re.addAll(combination(candidates, last - 1, target));
        
        ArrayList<ArrayList<Integer>> tmp = combination(candidates, last, target - candidates[last]);
        if (tmp != null) {
            for (ArrayList<Integer> al : tmp) {
                al.add(candidates[last]);
                re.add(al);
            }
        }
        return re;
    }
}
