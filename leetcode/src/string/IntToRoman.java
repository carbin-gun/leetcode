package string;
/**
 * Integer to Roma 
 *
 */
public class IntToRoman {
	public String intToRoman(int num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		String result = "";

		// Thousands
		result += toSymbol(num / 1000 % 10, "", "", "M");

		// Hundred
		result += toSymbol(num / 100 % 10, "M", "D", "C");

		// Ten
		result += toSymbol(num / 10 % 10, "C", "L", "X");

		// One
		result += toSymbol(num % 10, "X", "V", "I");

		return result;
	}

	public String toSymbol(int n, String ten, String five, String one) {
		String result = "";

		if (n == 9) {
			result = one + ten;
		} else if (n >= 5) {
			result = five;
			while (n-- > 5) {
				result += one;
			}
		} else if (n == 4) {
			result = one + five;
		} else if (n < 4 && n > 0) {
			while (n-- > 0) {
				result += one;
			}
		}
		return result;
	}
}
