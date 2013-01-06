package string;

/**
 * Valid Number
 * http://discuss.leetcode.com/questions/241/valid-number
 */
public class ValidNumber {
	public boolean isNumber(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        s = s.trim();
        if (s.equals("")) {
            return false;
        }
        int start = 0;
        while (start < s.length() && s.charAt(start) == ' ') {
        	start++;
        }
        if (start == s.length()) {
        	return false;
        }
        if (s.charAt(start) == '+' || s.charAt(start) == '-') {
        	start++;
        }
        s = s.substring(start);
        if (s.equals("")) {
        	return false;
        }
        int index = s.indexOf('e');
        if (index == -1) {
        	if (s.equals(".")) {
        		return false;
        	}
        	index = s.indexOf('.');
        	if (index == -1) {
        		return isClearNumber(s);
        	} else if(index == s.length() - 1) {
        		return isClearNumber(s.substring(0, index));
        	} else {
        		return isClearNumber(s.substring(0, index)) && isClearNumber(s.substring(index + 1));
        	}
        } else {
        	if (index == s.length() - 1) {
        		return false;
        	} else {
        		String p = s.substring(index + 1);
        		if(p.charAt(0) == '+' || p.charAt(0) == '-') {
        			p = p.substring(1);
        		}
        		if (p.equals("") || !isClearNumber(p)) {
        			return false;
        		}
        		s = s.substring(0, index);
        		if (s.equals("") || s.equals(".")) {
        			return false;
        		}
        		index = s.indexOf('.');
        		if (index == -1) {
        			return isClearNumber(s.substring(0));
        		} else if(index == s.length() - 1) {
        			return isClearNumber(s.substring(0, index));
        		} else {
        			return isClearNumber(s.substring(0, index)) && isClearNumber(s.substring(index + 1));
        		}
        	}
        }
    }
    
    public boolean isClearNumber(String s) {
    	for (int i = 0; i < s.length(); i++) {
    		if (s.charAt(i) < '0' || s.charAt(i) > '9') {
    			return false;
    		}
    	}
    	return true;
    }
}
