

/**
 * Decode Ways
 * 
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 'A' -> 1 'B' -> 2 ... 'Z' -> 26 Given an encoded message containing digits,
 * determine the total number of ways to decode it.
 * 
 * For example, Given encoded message "12", it could be decoded as "AB" (1 2) or
 * "L" (12).
 * 
 * The number of ways decoding "12" is 2.
 */

/*
 * DP idea, when using dp, please always use left-up to right-down, it is much more 
 * faster.
 */
public class DecodesWay {
	public int numDecodings(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s.length() == 0) {
			return 0;
		}
		int[] mask = new int[s.length() + 1];
		if (Integer.valueOf(s.substring(0, 1)) != 0) {
			mask[0] = 1;
			mask[1] = 1;
		} else {
			return 0;
		}
		for (int i = 2; i < mask.length; i++) {
			if (Integer.valueOf(s.substring(i - 1, i)) != 0) {
				mask[i] += mask[i - 1];
			}
			if (Integer.valueOf(s.substring(i - 2, i)) > 9
					&& Integer.valueOf(s.substring(i - 2, i)) < 27) {
				mask[i] += mask[i - 2];
			}

		}
		return mask[s.length()];
	}
}
