package string;

/**
 * String to Integer (atoi)
 * 
 */
public class StringToInteger {
	public int atoi(String str) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (str.equals("")) {
			return 0;
		}
		char[] strs = str.toCharArray();
		int i = 0;
		while (i < strs.length && strs[i] == ' ') {
			i++;
		}
		if (i == strs.length) {
			return 0;
		}
		boolean flag = true;
		if (strs[i] == '+') {
			flag = true;
			i++;
		} else if (strs[i] == '-') {
			flag = false;
			i++;
		}
		int result = 0;
		while (i < strs.length && strs[i] >= '0' && strs[i] <= '9') {
			if (flag
					&& (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && strs[i] - '0' >= 7))) {
				return Integer.MAX_VALUE;
			} else if (!flag
					&& (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && strs[i] - '0' >= 8))) {
				return Integer.MIN_VALUE;
			}
			result *= 10;
			result += (strs[i] - '0');
			i++;
		}
		if (!flag) {
			return -result;
		} else {
			return result;
		}
	}
}
