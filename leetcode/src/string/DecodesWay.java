package string;

/**
 * Decode Ways
 * Some times it is better not use the recursive method, instead of using straight-forward 
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
            if (Integer.valueOf(s.substring(i - 2, i - 1)) != 0 && Integer.valueOf(s.substring(i - 2, i)) < 27) {
    			mask[i] += mask[i - 2];
			}
			
		}
		return mask[s.length()];
	}
	
	public static void main(String argv[]) {
		new DecodesWay().numDecodings("10");
	}
}
