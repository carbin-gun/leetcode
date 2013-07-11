

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Subsets II
 * http://leetcode.com/questions/265/subsets-ii
 */
public class SubsetsII {
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
        re.add(new ArrayList<Integer>());
        if (S.length == 0) {
            return re;
        }
        Arrays.sort(S);
        int pre = 1;
        for (int i = 0; i < S.length; i++) {
            int start = 0;
            if (i != 0 && S[i] == S[i - 1]) {
                start = pre;
            }
            int n = re.size();
            for (int j = start; j < n; j++) {
                ArrayList<Integer> newElem = (ArrayList<Integer>)re.get(j).clone();
                newElem.add(S[i]);
                re.add(newElem);
            }
            pre = n;
        }
        return re;
    } 
}
