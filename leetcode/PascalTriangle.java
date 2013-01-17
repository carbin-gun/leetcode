import java.util.ArrayList;

/**
 * Pascal's Triangle
 * 
 * Given numRows, generate the first numRows of Pascal's triangle.
 * 
 * For example, given numRows = 5, Return
 *    [[1],
 *    [1,1],
 *   [1,2,1],
 *  [1,3,3,1],
 * [1,4,6,4,1]]
 * 
 * http://discuss.leetcode.com/questions/283/pascals-triangle
 */

/*
 * 
 */
public class PascalTriangle {
	public ArrayList<ArrayList<Integer>> generate(int numRows) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < numRows; i++) {
			ArrayList<Integer> cur = new ArrayList<Integer>();
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					cur.add(1);
				} else {
					cur.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
				}
			}
			ret.add(cur);
		}
		return ret;
	}
}
