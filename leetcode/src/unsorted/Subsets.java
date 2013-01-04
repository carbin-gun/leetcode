package unsorted;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Subsets
 * http://leetcode.com/questions/253/subsets
 */
public class Subsets {
	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
        re.add(new ArrayList<Integer>());
        if (S.length == 0) {
            return re;
        }
        Arrays.sort(S);
        for (int i = 0; i < S.length; i++) {
            int n = re.size();
            for (int j = 0; j < n; j++) {
                ArrayList<Integer> newElem = (ArrayList<Integer>)re.get(j).clone();
                newElem.add(S[i]);
                re.add(newElem);
            }
        }
        return re;
    }
}
