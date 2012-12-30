package unsorted;

import java.util.ArrayList;

/**
 * Pascal's Triangle II 
 *
 */
public class PascalTriangleII {
	public ArrayList<Integer> getRow(int rowIndex) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(1);
        for (int i = 1; i < rowIndex + 1; i++) {
        	int pre = 1;
        	for (int j = 1; j <= i; j++) {
        		if (j == i) {
        			result.add(1);
        		} else {
        			int tmp = result.get(j);
        			result.set(j, tmp + pre);
        			pre = tmp;
        		}
        	}
        }
        return result;
    }
}
