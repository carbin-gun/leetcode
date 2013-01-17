/**
 * Permutation Sequence The set [1,2,3,É,n] contains a total of n! unique
 * permutations.
 * 
 * By listing and labeling all of the permutations in order, We get the
 * following sequence (ie, for n = 3):
 * 
 * "123" "132" "213" "231" "312" "321" Given n and k, return the kth permutation
 * sequence.
 * 
 * Note: Given n will be between 1 and 9 inclusive.
 */

/*
 * The idea is that keep an array of n elements from small to large, the (n-1)!
 * elements always appears as a group, too get the kth permutation, we just put
 * the (k - 1)/(n-1)! at the first element, then keep the rest n - 1 elements
 * from small to large.
 */
public class PermutationSequence {
	public String getPermutation(int n, int k) {
		// Start typing your Java solution below
		// DO NOT write main() function
		char str[] = new char[n];
		int factor = 1;
		for (int i = 1; i <= n; i++) {
			str[i - 1] = (char) ('0' + i);
			factor *= i;
		}
		k = k - 1;
		factor /= n;
		for (int i = 0; i < n - 1; i++) {
			int selected = k / factor;
			k = k % factor;
			factor /= (n - i - 1);
			char tmp = str[selected + i];
			for (int j = selected; j > 0; j--) {
				str[i + j] = str[i + j - 1];
			}
			str[i] = tmp;
		}
		return new String(str);
	}
}
