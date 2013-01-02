package array;
/**
 * Rotate Image 
 * http://leetcode.com/questions/226/rotate-image
 */
public class RotateImage {
	public void rotate(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
        		int tmp = matrix[i][j];
        		matrix[i][j] = matrix[j][i];
        		matrix[j][i] = tmp;
        	}
        }
        for (int i = 0; i < matrix.length; i++) {
        	for (int j = 0; j < matrix.length / 2; j++) {
        		int tmp = matrix[i][j];
        		matrix[i][j] = matrix[i][matrix.length - 1 - j];
        		matrix[i][matrix.length - 1 - j] = tmp;
        	}
        }
    }
	
	public void rotateOutPlace(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[][] B = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
        	for (int j = 0; j < matrix.length; j++) {
        		B[j][matrix.length - i] = matrix[i][j];
        	}
        }
        for (int i = 0; i < matrix.length; i++) {
        	for (int j = 0; j < matrix.length; j++) {
        		matrix[i][j] = B[i][j];
        	}
        }
    }

}
