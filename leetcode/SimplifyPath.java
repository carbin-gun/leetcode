

import java.util.LinkedList;

/**
 * Simplify Path
 * to many corner case need to take care
 * Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return "/home/foo".
 * http://leetcode.com/questions/247/simplify-path
 */
public class SimplifyPath {
	public String simplifyPath(String path) {
    	// Start typing your Java solution below
	// DO NOT write main() function
	    String[] pathes = path.split("/");
            LinkedList<String> stack = new LinkedList();
            for (int i = 0; i < pathes.length; i++) {
                if (pathes[i].equals("..")) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else if (!pathes[i].equals("") && !pathes[i].equals(".")) {
                    stack.push(pathes[i]);
                }
            }
            StringBuilder sb = new StringBuilder("");
            if (stack.isEmpty()) {
                return "/";
            } else {
                while (!stack.isEmpty()) {
                    sb.append("/").append(stack.pollLast());
                }
            }
            return sb.toString();
	}
	
	public static void main(String argv[]) {
		SimplifyPath s = new SimplifyPath();
		System.out.print(s.simplifyPath("/.././GVzvE/./xBjU///../..///././//////T/../../.././zu/q/e"));
		String sb[] = "//////s//../".split("/");
		for (int i = 0; i < sb.length; i++) {
			System.out.println(sb[i]);
		}
	}
}
