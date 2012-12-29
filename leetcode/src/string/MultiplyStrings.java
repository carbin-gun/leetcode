package string;

/**
 * Multiply Strings be careful that we need multiply string from end to begin
 * 
 */
public class MultiplyStrings {

	public String multiply(String num1, String num2) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (num1 == "" || num2 == "")
			return "";
		if (num1.equals("0") || num2.equals("0"))
			return "0";
		int[] result = new int[num1.length() + num2.length() + 1];
		for (int i = 0; i < num1.length(); i++) {
			int carry = 0;
			int numi = Integer.valueOf(num1.substring(num1.length() - i - 1,
					num1.length() - i));
			for (int j = 0; j < num2.length(); j++) {
				int numj = Integer.valueOf(num2.substring(
						num2.length() - j - 1, num2.length() - j));
				int value = result[i + j] + numi * numj + carry;
				carry = value / 10;
				result[i + j] = value % 10;
			}
			result[i + num2.length()] = carry;
		}
		StringBuilder sb = new StringBuilder("");
		for (int i = result.length - 1; i >= 0; i--) {
			if (sb.length() != 0 || result[i] != 0) {
				sb.append(result[i]);
			}
		}
		return sb.toString();
	}
}