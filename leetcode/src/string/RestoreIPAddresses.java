package string;

import java.util.ArrayList;

/**
 * Restore IP Addresses
 * 
 */
public class RestoreIPAddresses {
	public ArrayList<String> restoreIpAddresses(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s.length() > 12) {
			return new ArrayList<String>();
		}
		return retoreIpAddresses(s, 4);
	}

	public ArrayList<String> retoreIpAddresses(String s, int n) {
		ArrayList<String> result = new ArrayList<String>();
		;
		if (n == 1 && s.length() > 0) {
			int value = Integer.valueOf(s);
			if ((value == 0 && s.length() == 1)
					|| (value <= 255 && value > 0 && s.charAt(0) != '0')) {
				result.add(s);
			}
		} else if (s.length() > 1) {
			for (int i = 1; i < 4; i++) {
				if (i < s.length()) {
					String sub = s.substring(0, i);
					int value = Integer.valueOf(sub);
					if ((value == 0 && sub.length() == 1)
							|| (value <= 255 && value > 0 && sub.charAt(0) != '0')) {
						ArrayList<String> tmp = retoreIpAddresses(
								s.substring(i), n - 1);
						for (String t : tmp) {
							result.add(sub + "." + t);
						}
					}
				}
			}
		}
		return result;
	}
}
