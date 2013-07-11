

import java.util.ArrayList;

/**
 * Sudoku Solver
 * 
 * @author kwwang
 * 
 */
public class SudokuSolver {
	public void solveSudoku(char[][] board) {
		// Start typing your Java solution below
		// DO NOT write main() function
		solvedSudoku(board);
	}

	public boolean solvedSudoku(char[][] board) {
		int row = 9;
		int column = 9;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					row = i;
					column = j;
					j = 9;
					j = 9;
				}
			}
		}
		if (row == 9) {
			return true;
		}
		ArrayList<Character> available = getAvailable(board, row, column);
		for (int i = 0; i < available.size(); i++) {
			board[row][column] = available.get(i);
			if (solvedSudoku(board)) {
				return true;
			}
			board[row][column] = '.';
		}
		return false;
	}

	public ArrayList<Character> getAvailable(char[][] board, int row, int column) {
		ArrayList<Character> re = new ArrayList<Character>();
		int[] av = new int[9];
		for (int i = 0; i < 9; i++) {
			if (board[row][i] != '.')
				av[board[row][i] - '1'] = 1;
			if (board[i][column] != '.')
				av[board[i][column] - '1'] = 1;
		}
		for (int i = (row / 3) * 3; i < (row / 3 + 1) * 3; i++) {
			for (int j = (column / 3) * 3; j < (column / 3 + 1) * 3; j++) {
				if (board[i][j] != '.')
					av[board[i][j] - '1'] = 1;
			}
		}

		for (int i = 0; i < 9; i++) {
			if (av[i] == 0) {
				re.add((char) ('1' + i));
			}
		}
		return re;
	}
}
