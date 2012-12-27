package string;

import java.util.ArrayList;

/**
 * Letter Combinations of a Phone Number
 * 
 */
public class LetterPhoneNumber {
	public ArrayList<String> letterCombinations(String digits) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<String> result = new ArrayList<String>();
		result.add("");
		if (digits.length() == 0)
			return result;
		if (digits.length() == 1) {
			return letter(result, Integer.valueOf(digits));
		} else {
			result = letterCombinations(digits
					.substring(0, digits.length() - 1));
			return letter(result,
					Integer.valueOf(digits.substring(digits.length() - 1)));
		}

	}

	public ArrayList<String> letter(ArrayList<String> arr, int digit) {
		ArrayList<String> newArr = new ArrayList<String>();
		for (String s : arr) {
			if (digit < 7) {
				newArr.add(s + (char) (digit * 3 + 91));
				newArr.add(s + (char) (digit * 3 + 92));
				newArr.add(s + (char) (digit * 3 + 93));
			}
			if (digit == 7) {
				newArr.add(s + (char) (digit * 3 + 91));
				newArr.add(s + (char) (digit * 3 + 92));
				newArr.add(s + (char) (digit * 3 + 93));
				newArr.add(s + (char) (digit * 3 + 94));
			} else if (digit == 8) {
				newArr.add(s + (char) (digit * 3 + 92));
				newArr.add(s + (char) (digit * 3 + 93));
				newArr.add(s + (char) (digit * 3 + 94));
			} else if (digit == 9) {
				newArr.add(s + (char) (digit * 3 + 92));
				newArr.add(s + (char) (digit * 3 + 93));
				newArr.add(s + (char) (digit * 3 + 94));
				newArr.add(s + (char) (digit * 3 + 95));
			}
		}
		return newArr;
	}

	public static void main(String argv[]) {
		LetterPhoneNumber a = new LetterPhoneNumber();
		System.out.println(a.letterCombinations("22"));
		for (String s : a.letterCombinations("2")) {
			System.out.println(s);
		}
	}

}
