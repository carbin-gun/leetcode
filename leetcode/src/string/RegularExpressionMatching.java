package string;

/**
 * Regular Expression Matching
 *
 */
public class RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
		return isMatch(s.toCharArray(), p.toCharArray(), 0, s.length(), 0, p.length());
	}
	
	public boolean isMatch(char[] s, char[] p, int s1, int e1, int s2, int e2) {
		if (e2 == s2) {
			return e1 == s1;
		} 
		if (e2 - s2 == 1 || p[s2 + 1] != '*') {
			if (s1 == e1) {
				return false;
			} else if (s[s1] != p[s2] && p[s2] != '.') {
				return false;
			} else {
				return isMatch(s, p, s1 + 1, e1, s2 + 1, e2);
			}
		} else {
			if (isMatch(s, p, s1, e1, s2 + 2, e2)) {
				return true;
			} else {
				while (s1 != e1 && (p[s2] == '.' || s[s1] == p[s2])) {
					if (isMatch(s, p, ++s1, e1, s2 + 2, e2)) {
						return true;
					}
				}
				return false;
			}
		}
	}
	
	
	public boolean isMatchNoneLarge(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if (p == "") {
        	return s == "";
        }
        if (p.indexOf('*') == -1) {
        	if (s.length() != p.length()) {
        		return false;
        	} else {
        		for (int i = 0; i < s.length(); i++) {
        			if (s.charAt(i) != p.charAt(i) && p.charAt(i) != '.') {
        				return false;
        			}
        		}
        		return true;
        	}
        } else {
        	int index = p.indexOf('*') - 1;
        	if (!isMatch(s.substring(0, index), p.substring(0, index))) {
        		return false;
        	} else if (isMatch(s.substring(index), p.substring(index + 2))){
        		return true;
        	} else {
        		char c = p.charAt(index);
        		int i = index;
        		while(i < s.length() && (s.charAt(i) == c || c == '.')) {
        			if (isMatch(s.substring(i + 1), p.substring(index + 2))) {
        				return true;
        			}
        			i++;
        		}
        		return false;
        	}
        }
	}
}
