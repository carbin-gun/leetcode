import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class TwoSigmaCodeTestJumbleSort {

	public static String sortStrings(String line) {
		if (line == null) {
			return null;
		}
		line = line.trim();
		if (line.length() == 0) {
			return "";
		}

		String strs[] = line.split("\\s");
		boolean isWord[] = new boolean[strs.length];
		ArrayList<String> words = new ArrayList<String>();
		ArrayList<Integer> integers = new ArrayList<Integer>();
		for (int i = 0; i < strs.length; i++) {
			if (isWord(strs[i])) {
				words.add(strs[i]);
				isWord[i] = true;
			} else {
				integers.add(Integer.valueOf(strs[i]));
			}
		}
		if (words.size() != 0) {
			Collections.sort(words);
		}
		if (integers.size() != 0) {
			Collections.sort(integers);
		}
		int indexWord = 0;
		int indexInteger = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < isWord.length; i++) {
			if (isWord[i]) {
				sb.append(words.get(indexWord)).append(" ");
				indexWord++;
			} else {
				sb.append(integers.get(indexInteger)).append(" ");
				indexInteger++;
			}
		}
		return sb.toString().trim();
	}

	public static boolean isWord(String str) {
		return str.matches("[a-z]+");
	}

	public static void main(String[] argvs) {
		String ret = "";
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		/* In case that assume the input is correct, so I did not judge anything */
		String line = "";
		try {
			line = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ret = sortStrings(line);
		System.out.println(ret);
	}
}
