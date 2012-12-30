package unsorted;

import java.util.ArrayList;

/**
 * N-Queens
 * I have finished in my own way, however there is a more clever method. I copy it on another file.
 * I will go check that later, it is in same idea, but more good code.
 */
public class NQueens {

	public ArrayList<String[]> solveNQueens(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<String[]> result = new ArrayList<String[]>();
		if (n == 0) {
			return result;
		}
		solveNQueens(result, null, n);
		return result;
	}

	public void solveNQueens(ArrayList<String[]> result, String[] candidate,
			int n) {
		if (candidate == null) {
			for (int i = 0; i < n; i++) {
				String newLine = generate(n, i);
				String[] newCandidate = new String[1];
				newCandidate[0] = newLine;
				solveNQueens(result, newCandidate, n);
			}
		} else if (candidate.length == n) {
			result.add(candidate);
			return;
		} else {
			int[] available = checkAvailable(candidate, n);
			for (int i = 0; i < n; i++) {
				if (available[i] == 0) {
					String newLine = generate(n, i);
					String[] newCandidate = new String[candidate.length + 1];
					for (int j = 0; j < candidate.length; j++) {
						newCandidate[j] = candidate[j];
					}
					newCandidate[candidate.length] = newLine;
					solveNQueens(result, newCandidate, n);
				}
			}
		}

	}

	public String generate(int n, int q) {
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < q; i++) {
			sb.append(".");
		}
		sb.append("Q");
		for (int i = q + 1; i < n; i++) {
			sb.append(".");
		}
		return sb.toString();
	}

	public int[] checkAvailable(String[] str, int n) {
		int[] available = new int[n];
		if (str == null)
			return available;
		int check = str.length;
		for (int i = 0; i < str.length; i++) {
			int position = str[i].indexOf('Q');
			available[position] = 1;
			if (position - check + i >= 0) {
				available[position - check + i] = 1;
			}
			if (position + check - i < n) {
				available[position + check - i] = 1;
			}
		}
		return available;
	}
	
	public static void main(String argv[]) {
		NQueens nq = new NQueens();
		String[] a = {"...Q","Q...","..Q."};
		int b[] = nq.checkAvailable(a, 4);
		for (int c : b) {
		System.out.print(c);
		}
		
	}
}
