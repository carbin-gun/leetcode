package array;

import java.util.Arrays;

/**
 * Median of Two Sorted Arrays
 * 
 */
public class MedianOfTwoSortedArrays {
	public double findMedianSortedArrays(int A[], int B[]) {
    	// Start typing your Java solution below
		// DO NOT write main() function
		if (A.length == 0) {
			return findMediaOneArray(B);
		} else if (B.length == 0) {
			return findMediaOneArray(A);
		}
		if (A.length > B.length) {
			return findMediaSortedArrays(A, 0, A.length - 1, B, 0, B.length - 1);
		} else {
			return findMediaSortedArrays(B, 0, B.length - 1, A, 0, A.length - 1);
		}
	}

	public double findMediaSortedArrays(int A[], int s1, int e1, int B[],
			int s2, int e2) {
		if (e2 - s2 < 4) {
			return findMediaBasedCase(A, s1, e1, B, s2, e2);
		} else {
			int mediaA = (e1 + s1) / 2;
			int mediaB = (e2 + s2) / 2;
			if (A[mediaA] > B[mediaB]) {
				if ((e2 - s2) % 2 == 0) {
					int k = mediaB - s2;
					return findMediaSortedArrays(A, s1, e1 - k, B, mediaB, e2);
				} else {
					int k = mediaB - s2 + 1;
					return findMediaSortedArrays(A, s1, e1 - k, B, mediaB + 1,
							e2);
				}
			} else {
				if ((e2 - s2) % 2 == 0) {
					int k = e2 - mediaB;
					return findMediaSortedArrays(A, s1 + k, e1, B, s2, mediaB);
				} else {
					int k = e2 - mediaB - 1;
					return findMediaSortedArrays(A, s1 + k, e1, B, s2,
							mediaB + 1);
				}

			}
		}
	}

	public double findMediaOneArray(int A[]) {
		int media = (A.length - 1) / 2;
		if (A.length % 2 == 1) {
			return A[media];
		} else {
			return (A[media] + A[media + 1]) / 2.0;
		}
	}

	public double findMediaBasedCase(int A[], int s1, int e1, int B[], int s2,
			int e2) {
		int C[] = new int[e1 - s1 + e2 - s2 + 2];
		for (int i = s1; i <= e1; i++) {
			C[i - s1] = A[i];
		}
		for (int i = s2; i <= e2; i++) {
			C[e1 - s1 + 1 + i - s2] = B[i];
		}
		Arrays.sort(C);
		int media = (C.length - 1) / 2;
		if (C.length % 2 == 1) {
			return C[media];
		} else {
			return (C[media] + C[media + 1]) / 2.0;
		}
	}
	
	public static void main(String argv[]) {
		
	}
}
