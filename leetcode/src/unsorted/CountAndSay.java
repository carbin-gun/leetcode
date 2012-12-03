package unsorted;
/**
 * Count and Say
 */
public class CountAndSay {
	public String countAndSay(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n == 1) {
            return "1";
        }
        String last = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        char pre = last.charAt(0);
        int count = 1;
        for (int i = 1; i < last.length(); i++) {
            if (last.charAt(i) == pre) {
                count++;
            } else {
                sb.append(count);
                sb.append(pre);
                count = 1;
                pre = last.charAt(i);
            }
        }
        sb.append(count);
        sb.append(pre);
        return sb.toString();
    }
}
