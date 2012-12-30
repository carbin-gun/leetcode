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
		if (i == 0) {
			for (int j = 0; j < num.length / 2; j++) {
				int tmp = num[j];
				num[j] = num[num.length - 1 - j];
				num[num.length - 1 - j] = tmp;
			}
		} else {
			Arrays.sort(num, i, num.length);
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
