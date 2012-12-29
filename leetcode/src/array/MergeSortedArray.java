package array;

/**
 * Merge Sorted Array
 * 
 */
public class MergeSortedArray {
	public void merge(int A[], int m, int B[], int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (m == 0) {
			for (int i = 0; i < n; i++) {
				A[i] = B[i];
			}
		} else {
			for (int i = m - 1; i >= 0; i--) {
				A[i + n] = A[i];
			}
			int p = 0;
			int pA = n;
			int pB = 0;
			while (pA != p && pA < m + n) {
				if (A[pA] <= B[pB]) {
					A[p] = A[pA];
					pA++;
				} else {
					A[p] = B[pB];
					pB++;
				}
				p++;
			}
			while (pB < n) {
				A[p] = B[pB];
				p++;
				pB++;
			}
		}
	}
}
