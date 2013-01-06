package string;

import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s == null || s.equals("")) {
			return true;
		}
		Stack<Character> checker = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			switch (c) {
			case '(':
			case '{':
			case '[':
				checker.push(c);
				break;
			case ']':
				if (!checker.isEmpty() && checker.peek() == '[') {
					checker.pop();
				} else {
					return false;
				}
				break;
			case ')':
				if (!checker.isEmpty() && checker.peek() == '(') {
					checker.pop();
				} else {
					return false;
				}
				break;
			case '}':
				if (!checker.isEmpty() && checker.peek() == '{') {
					checker.pop();
				} else {
					return false;
				}
				break;
			}
		}
		if (checker.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}
