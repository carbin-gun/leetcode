/**
 * Count and Say
 * 
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 
 * 1 is read off as "one 1" or 11. 11 is read off as "two 1s" or 21. 21 is read
 * off as "one 2, then one 1" or 1211. Given an integer n, generate the nth
 * sequence.
 * 
 * Note: The sequence of integers will be represented as a string.
 * http://discuss.leetcode.com/questions/217/count-and-say
 */

/*
 * It is every simple to solve the issue by a recursive method.
 */
public class CountAndSay {
	public String countAndSay(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (n == 1) {
			return "1";
		}
		String ret = countAndSay(n - 1);
		StringBuilder sb = new StringBuilder("");
		int count = 0;
		for (int i = 0; i < ret.length(); i++) {
			if (i != 0 && ret.charAt(i - 1) != ret.charAt(i)) {
				sb.append(count).append(ret.charAt(i - 1));
				count = 1;
			} else {
				count++;
			}
		}
		sb.append(count).append(ret.charAt(ret.length() - 1));
		return sb.toString();
	}
}
