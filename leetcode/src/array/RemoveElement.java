package array;
/**
 * Remove Element
 * http://leetcode.com/questions/208/remove-element
 */
public class RemoveElement {
	public int removeElement(int[] A, int elem) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A.length == 0) {
            return 0;
        }
        int index = -1;
        int cur = 0;
        while (cur < A.length) {
        	if (A[cur] != elem) {
        		A[++index] = A[cur];
        	}
        	cur++;
        }
        return index + 1;
    }
}
