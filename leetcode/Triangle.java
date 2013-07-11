

import java.util.ArrayList;
/**
 * Triangle
 * http://discuss.leetcode.com/questions/285/triangle
 */

public class Triangle {
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (triangle.size() == 0) {
            return 0;	
        }
        int ret = triangle.get(0).get(0);
        if (triangle.size() == 1) {
        	return ret;
        }
        ArrayList<Integer> cur = new ArrayList<Integer>();
        cur.add(ret);
        for (int i = 1; i < triangle.size(); i++) {
        	int left = cur.get(0);
        	ret = Integer.MAX_VALUE;
        	for (int j = 0; j < triangle.get(i).size(); j++) {
        		if (j < cur.size()) {
        			int tmp = cur.get(j);
        			cur.set(j, Math.min(left, tmp) + triangle.get(i).get(j)); 
        			left = tmp;
        		} else {
        			cur.add(left + triangle.get(i).get(j));
        		}
        		ret = Math.min(ret, cur.get(j));
        	}
        }
        return ret;
    }
}
