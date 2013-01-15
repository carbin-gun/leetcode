/**
 * Multiply Strings Given two numbers represented as strings, return
 * multiplication of the numbers as a string.
 * 
 * Note: The numbers can be arbitrarily large and are non-negative.
 * 
 * http://discuss.leetcode.com/questions/221/multiply-strings
 */

/*
 * Multiply one by one, take care of carry.
 */
public class MultiplyStrings {
	public String multiply(String num1, String num2) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int carry = 0;
		int[] ret = new int[num1.length() + num2.length() + 1];
		for (int i = 0; i < num1.length(); i++) {
			int n = num1.charAt(num1.length() - 1 - i) - '0';
			for (int j = 0; j < num2.length(); j++) {
				int m = num2.charAt(num2.length() - 1 - j) - '0';
				ret[i + j] += m * n + carry; // don't forget ret[i + j] itself.
				carry = ret[i + j] / 10;
				ret[i + j] %= 10;
			}
			ret[i + num2.length()] += carry;
			carry = 0;
		}
		StringBuilder sb = new StringBuilder("");
		boolean zero = true;
		for (int i = ret.length - 1; i >= 0; i--) {
			if (zero && ret[i] != 0) {
				zero = false;
			}
			if (!zero || i == 0) {
				sb.append(ret[i]);
			}
		}
		return sb.toString();
	}
}