package unsorted;

public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		// Start typing your Java solution below
		// DO NOT write main() function
		for (int i = 0; i < 9; i++) {
			int mask[] = new int[9];
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					int k = board[i][j] - '1';
					if (mask[k] == 0) {
						mask[k]++;
					} else {
						return false;
					}
				}
			}
		}

		for (int i = 0; i < 9; i++) {
			int mask[] = new int[9];
			for (int j = 0; j < 9; j++) {
				if (board[j][i] != '.') {
					int k = board[j][i] - '1';
					if (mask[k] == 0) {
						mask[k]++;
					} else {
						return false;
					}
				}
			}
		}

		for (int i = 0; i < 9; i = i + 3) {
			for (int j = 0; j < 9; j = j + 3) {
				if (!checkbox(board, i, j)) {
					return false;
				}
			}
		}

		return true;

	}

	public boolean checkbox(char[][] board, int raw, int column) {
		int mask[] = new int[9];
		for (int i = raw; i < raw + 3; i++) {
			for (int j = column; j < column + 3; j++) {
				if (board[i][j] != '.') {
					int k = board[i][j] - '1';
					if (mask[k] == 0) {
						mask[k]++;
					} else {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public static void main(String argv[]) {
		char[][] test = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
		System.out.println(new ValidSudoku().isValidSudoku(test));
	}
}
