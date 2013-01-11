import java.util.ArrayList;

/**
 * Generate Parentheses Given n pairs of parentheses, write a function to
 * generate all combinations of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * 
 * http://discuss.leetcode.com/questions/203/generate-parentheses
 */

/*
 * It is a DFS. The key rule is like generate start from the empty "", and for
 * every time add a character it can either add ( or ), but we can not add )
 * when current number of ( is not larger than ), or ( is larger then half of
 * the total length.
 */
public class GenerateParentheses {
	public ArrayList<String> generateParenthesis(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<String> ret = new ArrayList<String>();
		generateParenthesis(ret, "", n, 0, 0);
		return ret;
	}

	public void generateParenthesis(ArrayList<String> ret, String par, int n,
			int leftTotal, int leftUnMatched) {
		// this judgment should be always put in the most beginning.
		if (leftTotal > n) {
			return;
		}
		if (par.length() == 2 * n) {
			ret.add(par);
			return;
		}
		if (leftUnMatched > 0) {
			generateParenthesis(ret, par + ")", n, leftTotal, leftUnMatched - 1);
		}
		generateParenthesis(ret, par + "(", n, leftTotal + 1, leftUnMatched + 1);
	}
}
