package array;

import java.util.Arrays;

/**
 * Next Permutation
 * the idea should be remembered, is to found the first position that num[i] > num[i - 1]
 * then sort element after i(include i). replace [i - 1] to the first number after i that
 * larger than num[i - 1]
 */
public class NextPermutation {
	public void nextPermutation(int[] num) {
    	// Start typing your Java solution below
		// DO NOT write main() function
		if (num == null || num.length <= 1) {
			return;
		}
		int i = num.length - 1;
		while (i > 0 && num[i] <= num[i - 1]) {
			i--;
		}
		for (int j = i; j < (num.length + i) / 2; j++) {
				int tmp = num[j];
				num[j] = num[num.length - 1 - j + i];
				num[num.length - 1 - j + i] = tmp;
		}
		if (i != 0) {
			int replace = num[i - 1];
			for (int j = i; j < num.length; j++) {
				if (replace < num[j]) {
					num[i - 1] = num[j];
					num[j] = replace;
					break;
				}
			}
		}
	}
}
