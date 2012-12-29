package unsorted;

/**
 * First Missing Positive
 * based on the idea make A[i] = i + 1, and switch the value to the right position.
 */
public class FirstMissingInteger {
	public int firstMissingPositive(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        for(int i = 0; i < A.length; i++) {
           while (A[i] != (i + 1)) {
               if (A[i] <= 0 || A[i] > (A.length - 1) || A[i] == A[A[i] - 1]) break;
               int tmp = A[i];
               A[i] = A[tmp - 1];
               A[tmp - 1] = tmp;
           }
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1)
                return i + 1;
        }
        return A.length + 1;
    }
}
