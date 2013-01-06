package string;

import java.util.ArrayList;

/**
 * Text Justification
 * http://discuss.leetcode.com/questions/244/text-justification
 * 
 */
public class TextJustification {
	public ArrayList<String> fullJustify(String[] words, int L) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<String> re = new ArrayList<String>();
		if (words.length == 0) {
			return re;
		}
		int index = 0;
		while (index < words.length) {
			int start = index;
			int end = index + 1;
			int counter = words[start].length();
			while (end < words.length && counter + 1 + words[end].length() <= L) {
				counter = counter + 1 + words[end].length();
				end++;
			}
			re.add(formALine(words, start, end - 1, L - counter));
			index = end;
		}
		return re;
	}

	public String formALine(String[] words, int start, int end, int extra) {
		String sep = "";
		StringBuilder sb = new StringBuilder("");
		if (start == end || end == words.length - 1) {
			for (int i = 0; i < extra; i++) {
				sep += " ";
			}
			sb.append(words[start]);
			for (int i = start + 1; i <= end; i++) {
				sb.append(" ").append(words[i]);
			}
			sb.append(sep);
		} else {
			int base = extra / (end - start);
			for (int i = 0; i <= base; i++) {
				sep += " ";
			}
			int addition = extra % (end - start);
			for (int i = start; i < end; i++) {
				sb.append(words[i]);
				sb.append(sep);
				if (i - start < addition) {
					sb.append(" ");
				}
			}
			sb.append(words[end]);
		}
		return sb.toString();
	}

	public static void main(String argv[]) {
		TextJustification tj = new TextJustification();
		String[] words = { "What", "must", "be", "shall", "be." };
		System.out.println(tj.fullJustify(words, 12));
	}
}
