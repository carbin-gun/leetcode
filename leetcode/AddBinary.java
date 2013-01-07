/**
 * Given two binary strings, return their sum (also a binary string).
 * 
 * For example, a = "11" b = "1" Return "100".
 * http://discuss.leetcode.com/questions/243/add-binary
 */

/*
 * This is a easy question, need to take care of the start point of when one string is 
 * used up, and another is not. 
 */

public class AddBinary {
	public String addBinary(String a, String b) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (a.equals("") && b.equals("")) {
			return "";
		} else if (a.equals("")) {
			return b;
		} else if (b.equals("")) {
			return a;
		}
		StringBuilder sb = new StringBuilder("");
		String small = a.length() > b.length() ? b : a;
		String large = a.length() > b.length() ? a : b;
		int carry = 0;
		for (int i = 0; i < small.length(); i++) {
			int x = small.charAt(small.length() - 1 - i) - '0';
			int y = large.charAt(large.length() - 1 - i) - '0';
			int sum = x + y + carry;
			sb.append(sum % 2);
			carry = sum / 2;
		}
		for (int i = large.length() - small.length() - 1; i >= 0; i--) {
			// above line is where I always mess up.
			int x = large.charAt(i) - '0';
			int sum = x + carry;
			sb.append(sum % 2);
			carry = sum / 2;
		}
		if (carry == 1) {
			sb.append(1);
		}
		return sb.reverse().toString();
	}

	public static void main(String argv[]) {
		System.out.println(new AddBinary().addBinary("11", "1"));
	}
}
