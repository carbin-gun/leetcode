package array;

import java.util.Arrays;

/**
 * Median of Two Sorted Arrays
 * it is a hug complex base case;
 */
public class MedianOfTwoSortedArrays {
	public double findMedianSortedArrays(int A[], int B[]) {
    	// Start typing your Java solution below
		// DO NOT write main() function
		if (A.length == 0) {
			return findMediaOneArray(B, 0, B.length - 1);
		} else if (B.length == 0) {
			return findMediaOneArray(A, 0, A.length - 1);
		}
		if (A.length > B.length) {
			return findMediaSortedArrays(A, 0, A.length - 1, B, 0, B.length - 1);
		} else {
			return findMediaSortedArrays(B, 0, B.length - 1, A, 0, A.length - 1);
		}
	}

	public double findMediaSortedArrays(int A[], int s1, int e1, int B[],
			int s2, int e2) {
		if (e2 - s2 == 0) {
			return findMediaBasedCase(A, s1, e1, B[s2]);
		} else if(e2 - s2 == 1) {
			return findMediaBasedCase(A, s1, e1, B[s2], B[e2]);
		}else {
			int mediaA = (e1 + s1) / 2;
			int mediaB = (e2 + s2) / 2;
			if (A[mediaA] > B[mediaB]) {
				if ((e2 - s2) % 2 == 0) {
					int k = mediaB - s2;
					return findMediaSortedArrays(A, s1, e1 - k, B, mediaB, e2);
				} else {
					int k = mediaB - s2;
					return findMediaSortedArrays(A, s1, e1 - k, B, mediaB, e2);
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

	public double findMediaOneArray(int A[], int s, int e) {
		int media = (s + e) / 2;
		if ((e - s) % 2 == 0) {
			return A[media];
		} else {
			return (A[media] + A[media + 1]) / 2.0;
		}
	}
	
	public double findMediaBasedCase(int A[], int s, int e, int med1) {
		if (s == e) {
			return (A[s] + med1) / 2.0;
		}
		int mid = (s + e) / 2;
		if ((e - s) % 2 == 1) {
			if (med1 < A[mid]) {
				return A[mid];
			} else if (med1 < A[mid + 1]) {
				return med1;
			} else {
				return A[mid + 1];
			}
		} else {
			if (med1 < A[mid - 1]) {
				return (A[mid] + A[mid - 1]) / 2.0;
			} else if (med1 < A[mid + 1]) {
				return (A[mid] + med1) / 2.0;
			} else {
				return (A[mid] + A[mid + 1]) / 2.0;
			}
		}
	}
	
	public double findMediaBasedCase(int A[], int s, int e, int med1, int med2) {
		int mid = (s + e) / 2;
		if ((e - s) % 2 == 1) {
			int a = (mid - 1) >= s ? A[mid - 1] : Integer.MIN_VALUE;
			int b = A[mid];
			int c = A[mid + 1];
			int d = (mid + 2) <= e ? A[mid + 2] : Integer.MAX_VALUE;
			if (med2 <= b) {
				return (b + Math.max(a, med2)) / 2.0;
			} else if (med1 <= b) {
				return (b + Math.min(c, med2)) / 2.0;
			} else if (med1 >= c) {
				return (c + Math.min(d, med1)) / 2.0;
			} else if (med2 >= c) {
				return (c + Math.max(b, med1)) / 2.0;
			} else {
				return (med1 + med2) / 2.0;
			}
		} else {
			if (med1 >= A[mid]) {
				return Math.min(med1, A[mid + 1]);
			} else if (med2 <= A[mid]) {
				return Math.max(med2, A[mid - 1]);
			} else {
				return A[mid];
			}

		}
	}
	
	public static void main(String argv[]) {
		
	}
}
