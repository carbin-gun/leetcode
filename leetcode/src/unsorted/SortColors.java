package unsorted;

/**
 * Sort Colors
 * http://leetcode.com/questions/251/sort-colors
 */
public class SortColors {
	public void sortColors(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (A.length < 2) {
			return;
		}
		int pR = 0;
		int sRW = Integer.MAX_VALUE;
		int pW = 0;
		int scaner = 0;
		while (scaner < A.length) {
			if (A[scaner] == 0) {
				if (pR < sRW) {
					swap(A, scaner, pR);
					pR++;
				} else {
					swap(A, scaner, pR);
					pR++;
					sRW++;
					swap(A, scaner, pW);
					pW++;
				}
			} else if (A[scaner] == 1) {
				if (sRW == Integer.MAX_VALUE) {
					pW = pR;
					sRW = pW;
				}
				swap(A, scaner, pW);
				pW++;
			}
			scaner++;
		}
	}

	public void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
}
