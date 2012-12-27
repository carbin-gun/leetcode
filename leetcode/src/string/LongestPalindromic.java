package string;

/**
 * Longest Palindromic Substring
 * which need to take much more careful.
 */
public class LongestPalindromic {
	public String longestPalindrome(String s) {
		if (s.length() == 0) {
			return "";
		} else if (s.length() == 1) {
			return s;
		}
		String t = preProcess(s);
		int p[] = new int[t.length()];
		int c = 0;
		int r = 0;
		for (int i = 1; i < t.length() - 1; i++) {
			int mirror = c * 2 - i;
			p[i] = (r > i) ? Math.min(r - i, p[mirror]) : 0;
			while (t.charAt(i - p[i] - 1) == t.charAt(i + p[i] + 1)) {
				p[i]++;
			}
			if (i + p[i] > r) {
				c = i;
				r = i + p[i];
			}
		}

		int max = Integer.MIN_VALUE;
		int index = -1;
		for (int i = 0; i < p.length; i++) {
			if (max < p[i]) {
				max = p[i];
				index = i;
			}
		}
		StringBuilder result = new StringBuilder();
		for (int i = index - p[index] + 1; i < index + p[index]; i += 2) {
			result.append(t.charAt(i));
		}
		return result.toString();
	}

	public String preProcess(String s) {
		StringBuilder t = new StringBuilder();
		t.append("$#");
		for (int i = 0; i < s.length(); i++) {
			t.append(s.charAt(i));
			t.append("#");
		}
		t.append("^");
		return t.toString();
	}
	
	public static void main(String argv[]) {
		LongestPalindromic lp = new LongestPalindromic();
		System.out.println(lp.longestPalindrome("bbaabb"));
	}
}
