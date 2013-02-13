/**
 * Plus One
 * 
 * Given a number represented as an array of digits, plus one to the number.
 * 
 * http://discuss.leetcode.com/questions/242/plus-one
 */
public class PlusOne {
	public int[] plusOne(int[] digits) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int carry = 0;
		digits[digits.length - 1] += 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			digits[i] = digits[i] + carry;
			carry = digits[i] / 10;
			digits[i] %= 10;
		}
		if (carry == 0) {
			return digits;
		} else {
			int[] newDigits = new int[digits.length + 1];
			for (int i = 0; i < digits.length; i++) {
				newDigits[i + 1] = digits[i];
				newDigits[0] = carry;
			}
			return newDigits;
		}
	}

}
