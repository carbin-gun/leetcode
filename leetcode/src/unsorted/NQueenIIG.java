package unsorted;

public class NQueenIIG {
	public int totalNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
         
        int[] count = new int[1];
        if (n <= 0) {
            return 0;
        }
 
        int[] sol = new int[n]; //the i-th element is the column number of the queen in the i-th row
 
        placeQueen(sol, 0, count);
        return count[0];
    }
 
    public void placeQueen(int[] sol, int row, int[] count) {
        int n = sol.length;
        if (row == n) {
            count[0]++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!taken(sol, row, i)) {
                sol[row] = i;
                placeQueen(sol, row+1, count);
            }
        }
    }
 
    public boolean taken(int[] sol, int row, int col) {
        //check col and diag
        for (int i = 0; i < row; i++) {
            if (sol[i] == col) {
                return true;
            }
            if (row-i == Math.abs(col-sol[i])) {
                return true;
            }
        }
 
        return false;
    }
}
