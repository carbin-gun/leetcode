

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
		LinkedList<String> simple = new LinkedList<String>();
		path = path.substring(1);
		int index = path.indexOf('/');
		while (index != -1) {
			String subPath = path.substring(0, index);
			if (subPath.equals("..") && !simple.isEmpty()) {
					simple.removeLast();
			} else if (subPath.length() != 0 && !subPath.equals(".") && !subPath.equals("..")) {
				simple.add(subPath);
			}
			if (path.length() > index + 1) {
				path = path.substring(index + 1);
			} else {
				path = "";
			}
			index = path.indexOf('/');
		}
		if (path.equals("..") && !simple.isEmpty()) {
			simple.removeLast();
		} else if (!path.equals("") && !path.equals(".") && !path.equals("..")) {
            simple.add(path);
        } 
		if (simple.isEmpty()) {
			return "/";
		}
		StringBuilder sb = new StringBuilder("");
		while (!simple.isEmpty()) {
			sb.append("/");
			sb.append(simple.poll());
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
