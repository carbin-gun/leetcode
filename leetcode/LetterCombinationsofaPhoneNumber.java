import java.util.ArrayList;

/**
 * Letter Combinations of a Phone Number
 * 
 * Given a digit string, return all possible letter combinations that the number
 * could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below.
 * 
 * http://discuss.leetcode.com/questions/198/letter-combinations-of-a-phone-number
 */

/*
 * Recursive method to solve it.
 */
public class LetterCombinationsofaPhoneNumber {
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
			char[] choices = getX(digit).toCharArray();
			for (char c : choices) {
				newArr.add(s + c);
			}
		}
		return newArr;
	}
	
	public String getX (int i) {
        String[] arr = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        return arr[i];
    }
}
