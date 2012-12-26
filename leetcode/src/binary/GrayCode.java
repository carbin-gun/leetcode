package binary;

import java.util.ArrayList;

/**
 * Gray Code
 */
public class GrayCode {
	public ArrayList<Integer> grayCode(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> re = new ArrayList<Integer>();
        if (n == 0) {
            re.add(0);
            return re;
        }
        int m =  n > 1 ? 1 << (n - 1) : 1;
        re.addAll(grayCode(n - 1));
        for (int i = re.size() - 1; i >= 0; i--) {
            re.add(re.get(i) + m);
        }
        return re;
    }
}
