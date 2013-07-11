import java.util.ArrayList;

/**
 * Gray Code
 * 
 * The gray code is a binary numeral system where two successive values differ
 * in only one bit.
 * 
 * Given a non-negative integer n representing the total number of bits in the
 * code, print the sequence of gray code. A gray code sequence must begin with
 * 0.
 * 
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * Note: For a given n, a gray code sequence is not uniquely defined.
 * 
 * For example, [0,2,3,1] is also a valid gray code sequence according to the
 * above definition.
 * 
 * http://discuss.leetcode.com/questions/264/gray-code
 */

/*
 * Normally it can be done by recursive, however here I just provide a clear solution
 * without recursive.
 */
public class GrayCode {
	public ArrayList<Integer> grayCode(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> ret = new ArrayList<Integer>();
		ret.add(0);
		int e = 1;
		for (int i = 0; i < n; i++) {
			for (int j = ret.size() - 1; j >= 0; j--) {
				ret.add(ret.get(j) + e);
			}
			e <<= 1;
		}
		return ret;
	}
	
	public int grayCodeN(int index) {
		if (index == 1) {
			return 0;
		} 
		int x = 1;
		while (x < index) {
			x *= 2;
		}
		return grayCodeN(x + 1 - index) + x / 2;
	}
	
	public static void main(String arg[]) {
		GrayCode g = new GrayCode();
		ArrayList<Integer> result = g.grayCode(8);
		for (int i = 1; i <= 256; i++) {
			System.out.println(i + ":" + result.get(i - 1) + "-" + g.grayCodeN(i));
		}
	}
}
