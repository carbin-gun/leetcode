

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
	
	public ArrayList<String> restoreIpAddressesNonRecursive(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
		ArrayList<String> ret = new ArrayList<String>();
        if (s.length() < 4) {
            return ret;
        }
        for (int i = 1; i < 4; i++) {
            String first = s.substring(0, i);
            if ((first.charAt(0) == '0' && first.length() != 1) 
              || Integer.valueOf(first) < 0 || Integer.valueOf(first) > 255) {
                  continue;
              }
            for (int j = i + 1; j < i + 4 && j < s.length() - 1; j++) {
                String second = s.substring(i, j);
                if ((second.charAt(0) == '0' && second.length() != 1) 
              || Integer.valueOf(second) < 0 || Integer.valueOf(second) > 255) {
                  continue;
                }
                
                for (int k = j + 1; k < j + 4 && k < s.length(); k++) {
                    String third = s.substring(j, k);
                    if ((third.charAt(0) == '0' && third.length() != 1) 
                    || Integer.valueOf(third) < 0 || Integer.valueOf(third) > 255) {
                        continue;
                    }
                    if (s.length() - k > 3) {
                        continue;
                    } 
                    String forth = s.substring(k);
                    if ((forth.charAt(0) == '0' && forth.length() != 1) 
                    || Integer.valueOf(forth) < 0 || Integer.valueOf(forth) > 255) {
                        continue;
                    }
                    ret.add(first + "." + second + "." + third + "." + forth);
                }
            }
        }
        return ret;
    }
	
	public static void main(String argv[]) {
		RestoreIPAddresses ri = new RestoreIPAddresses();
		ri.restoreIpAddressesNonRecursive("0000");
	}
	
}
