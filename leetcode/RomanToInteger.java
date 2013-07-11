

import java.util.HashMap;

/**
 * Roman to Integer
 *	http://leetcode.com/questions/195/roman-to-integer
 */
public class RomanToInteger {
	public int romanToInt(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int result = 0;
        HashMap<Character, Integer> roman = new HashMap<Character, Integer>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
        	if (i == 0) {
        		sum = roman.get(s.charAt(i));
        	} else if (roman.get(s.charAt(i)) == roman.get(s.charAt(i - 1))) {
        		sum += roman.get(s.charAt(i));
        	} else if (roman.get(s.charAt(i)) < roman.get(s.charAt(i - 1))) {
        		result += sum;
        		sum = roman.get(s.charAt(i));
        	} else {
        		result += roman.get(s.charAt(i)) - sum;
        		sum = 0;
        	}
        }
        result += sum;
        return result;
    }

}
