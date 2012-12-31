package string;
/**
 * ZigZag Conversion
 * http://leetcode.com/questions/190/zigzag-conversion 
 *
 */
public class ZigZagConversion {
	public String convert(String s, int nRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if (nRows == 1) {
			return s;
		}
        int loop = nRows * 2 - 2;
        StringBuilder sb = new StringBuilder("");
        int first = loop;
    	int last = 0;
        for (int i = 0; i < nRows; i++) {
        	int index = i;
        	while (index < s.length()) {
        		if (index < s.length() && first != 0) {
        			sb.append(s.charAt(index));
        		}
        		index += first;
        		if (index < s.length() && last != 0) {
        			sb.append(s.charAt(index));
        		}
        		index += last;
        	}
        	first -= 2;
        	last += 2;
        }
        return sb.toString();
    }
	
	public static void main(String argv[]) {
		ZigZagConversion zz = new ZigZagConversion();
//		System.out.println(zz.convert("PAYPALISHIRING", 4));
		System.out.println(zz.convert("A", 1));
	}
}
