/**
 * Merge Sorted Array
 * 
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * 
 * Note: You may assume that A has enough space to hold additional elements from
 * B. The number of elements initialized in A and B are m and n respectively.
 * 
 * http://discuss.leetcode.com/questions/263/merge-sorted-array
 */

/*
 * it is a o(m + n) solution, take care when you move A's elements to it's end, 
 * need to start from the end to front to avoid the conflict. 
 */
public class MergeSortedArray {
	public void merge(int A[], int m, int B[], int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		for (int i = m - 1; i >= 0; i--) {
			A[i + n] = A[i];
		}
		int i = n, j = 0, index = 0;
		while (i < m + n && j < n) {
			if (A[i] < B[j]) {
				A[index] = A[i];
				i++;
			} else {
				A[index] = B[j];
				j++;
			}
			index++;
		}
		if (j < n) {
			while (index < m + n) {
				A[index] = B[j];
				j++;
				index++;
			}
		}
	}
}
