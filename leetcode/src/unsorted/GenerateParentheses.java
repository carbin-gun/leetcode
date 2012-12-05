package unsorted;

import java.util.ArrayList;
/**
 *	Generate Parentheses 
 * The key rule is like generate start from the empty "", and for every time add
 * a character it can either add ( or ), but we can not add ) when current number of ( 
 * is not larger than ), or ( is larger then half of the total length.
 */
public class GenerateParentheses {
	public ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> re = new ArrayList<String>();
        generateParenthesis(0, 2 * n, 0, 0, "", re);
        return re;
        
    }
    
    public void generateParenthesis(int total, int max, int left, int leftTotal, String s, ArrayList<String> re) {
        if (leftTotal * 2 > max)
            return;
        
        if (total == max) {
            re.add(s);
            return;
        }
        
        if (left > 0)
            generateParenthesis(total + 1, max, left - 1, leftTotal, s + ")", re);
        
        generateParenthesis(total + 1, max, left + 1, leftTotal+1, s + "(", re);
        
        
    }
}
