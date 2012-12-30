package unsorted;

import java.util.ArrayList;

/**
 * Pascal's Triangle
 * 
 */

public class PascalTriangle {
	public ArrayList<ArrayList<Integer>> generate(int numRows) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		if (numRows == 0) {
			return result;
		}
		for (int i = 0; i < numRows; i++) {
			ArrayList<Integer> row = new ArrayList<Integer>();
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					row.add(1);
				} else {
					row.add(result.get(i - 1).get(j - 1)
							+ result.get(i - 1).get(j));
				}
			}
			result.add(row);
		}
		return result;
	}
}
