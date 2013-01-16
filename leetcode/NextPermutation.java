/**
 * Next Permutation Implement next permutation, which rearranges numbers into
 * the lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest
 * possible order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place, do not allocate extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its
 * corresponding outputs are in the right-hand column.
 * 
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * 
 * http://discuss.leetcode.com/questions/211/next-permutation
 */

/*
 * the idea should be remembered, is to found the first position that num[i] >
 * num[i - 1] then sort element after i(include i). replace [i - 1] to the first
 * number after i that larger than num[i - 1]
 */
public class NextPermutation {
	public void nextPermutation(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int start = num.length - 2;
		while (start >= 0 && num[start] >= num[start + 1]) {
			start--;
		}
		int exchange = start + 1;
		for (int i = 0; i < (num.length - exchange) / 2; i++) {
			int tmp = num[exchange + i];
			num[exchange + i] = num[num.length - 1 - i];
			num[num.length - 1 - i] = tmp;
		}
		if (start != -1) {
			for (int i = exchange; i < num.length; i++) {
				if (num[start] < num[i]) {
					int tmp = num[start];
					num[start] = num[i];
					num[i] = tmp;
					break;
				}
			}
		}
	}
}
