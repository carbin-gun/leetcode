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
		StringBuilder sb = new StringBuilder();
        int carry = 0;
        int p = a.length() - 1;
        int q = b.length() - 1;
        while (p >= 0 && q >= 0) {
            int i = a.charAt(p) - '0';
            int j = b.charAt(q) - '0';
            int sum = carry + i + j;
            carry = sum / 2;
            sb.append(sum % 2);
            p--;
            q--;
        }
        if (p < 0) {
            while (q >= 0) {
                int i = b.charAt(q) - '0';
                int sum = carry + i;
                carry = sum / 2;
                sb.append(sum % 2);
                q--;
            }
        } else {
            while (p >= 0) {
                int i = a.charAt(p) - '0';
                int sum = carry + i;
                carry = sum / 2;
                sb.append(sum % 2);
                p--;
            }
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
