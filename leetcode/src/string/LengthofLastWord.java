package string;


/**
 * Length of Last Word 
 *
 */
public class LengthofLastWord {
	public int lengthOfLastWord(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s == null || s == "") {
            return 0;
        }
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        int num = 0;
        while (i >= 0 && s.charAt(i) != ' ') {
             num++;
             i--;
        }
        return num;
    }
}
