package string;

/**
 * Wildcard Matching
 *
 */
public class WildcardMatching {
	public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        boolean[] ret = new boolean[s.length() + 1];
        ret[0] = true;
    	for (int j = 1; j <= p.length(); j++) {
    		boolean pre = ret[0];
    		if (p.charAt(j - 1) == '*') {
    			ret[0] = ret[0] && true;
    		} else {
    			ret[0] = false;
    		}
            boolean checker = ret[0];
    		for (int i = 1; i <= s.length(); i++) {
    			if (p.charAt(j - 1) == '*') {
    				pre = ret[i];
    				ret[i] = ret[i] || ret[i - 1];
    			} else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
    				boolean tmp = ret[i];
    				ret[i] = pre;
    				pre = tmp;
    			} else {
    				pre = ret[i];
    				ret[i] = false;
    			}
                checker = checker || ret[i];
    		}
    		if (checker == false) {
        		return false;
    		}
    	}
    	return ret[s.length()];
    }
	
	public boolean isMatched(String s, String p) {
		System.out.println("s="+s+"   p="+p);
		int index = p.indexOf('*');
		if (index == -1) {
			return isMatchNoStar(s, p);
		} else {
			if (s.length() < index) {
				return false;
			} else if (!isMatchNoStar(s.substring(0, index), p.substring(0, index))) {
				return false;
			} else {
				for (int i = index; i <= s.length(); i++) {
					if (isMatch(s.substring(i), p.substring(index + 1))) {
						return true;
					}
				}
				return false;
			}
		}
	}
	
	public boolean isMatchNoStar(String s, String p) {
		System.out.println("nostar:s="+s+"   p="+p);
		if (s.length() != p.length()) {
			return false;
		}
		for (int i = 0; i < s.length(); i++) {
			if (p.charAt(i) != '?' && s.charAt(i) != p.charAt(i)) {
				return false;
			}
		}
		return true;
		
	}
	
	
	
	
	public boolean isMatchNoLargeData(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
 
        int i = 0, j = 0;
 
        //the following is a recursive one, it timed out on large input
        if (p.length() == 0) {
            return s.length() == 0;
        }
        if (s.length() == 0) {
            return p.equals("") || allStar(p);
        }
 
        if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?') {
            return isMatchNoLargeData(s.substring(1), p.substring(1));
        }
 
        if (p.charAt(0) == '*') {
            return isMatchNoLargeData(s.substring(1), p) || isMatchNoLargeData(s, p.substring(1));
        }
 
        return false;
    }
 
    public boolean allStar (String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }

	
	public boolean isMatchMemoryTooLarge(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        boolean[][] ret = new boolean[s.length() + 1][p.length() + 1];
    	ret[0][0] = true;
    	for (int j = 1; j <= p.length(); j++) {
    		if (p.charAt(j - 1) == '*') {
    			ret[0][j] = ret[0][j - 1];
    		}
    	}
    	for (int i = 1; i <= s.length(); i++) {
    		for (int j = 1; j <= p.length(); j++) {
    			if (p.charAt(j - 1) == '*') {
    				ret[i][j] = ret[i - 1][j] || ret[i][j - 1];
    			} else if (p.charAt(j - 1) == '?') {
    				ret[i][j] = ret[i - 1][j - 1];
    			} else if (s.charAt(i - 1) == p.charAt(j - 1)) {
    				ret[i][j] = ret[i - 1][j - 1];
    			}
    		}
    	}
    	return ret[s.length()][p.length()];
    }
	
	public static void main (String argv[]) {
		System.out.print(new WildcardMatching().isMatch("c", "*?*"));
	}
}
