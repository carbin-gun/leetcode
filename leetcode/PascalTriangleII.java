import java.util.ArrayList;

/**
 * Pascal's Triangle II
 * 
 * Given an index k, return the kth row of the Pascal's triangle.
 * 
 * For example, given k = 3, Return [1,3,3,1].
 */

/*
 * This is a solution use O(n) space;
 */
public class PascalTriangleII {
	public ArrayList<Integer> getRow(int rowIndex) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> ret = new ArrayList<Integer>();
		for (int i = 0; i <= rowIndex; i++) {
			int pre = 0;
			for (int j = 0; j < ret.size(); j++) {
				int cur = ret.get(j);
				ret.set(j, cur + pre);
				pre = cur;
			}
			ret.add(1);
		}
		return ret;
	}
}
