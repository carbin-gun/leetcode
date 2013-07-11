

import java.util.HashMap;

/**
 * Two Sum
 * http://leetcode.com/questions/188/two-sum
 */
public class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int result[] = new int[2];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			int valNeed = target - numbers[i];
			if (map.containsKey(valNeed)) {
				result[0] = map.get(valNeed);
				result[1] = i + 1;
				break;
			}
			map.put(numbers[i], i + 1);
		}
		return result;
	}
}
