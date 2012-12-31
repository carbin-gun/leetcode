package tree;

import java.util.Stack;

/**
 * Symmetric Tree
 * http://leetcode.com/questions/274/symmetric-tree
 * Given a binary tree, check whether it is a mirror of itself
 * (ie, symmetric around its center).
 */
public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack<Integer> s = new Stack<Integer>();
		if (root == null) {
			return true;
		}
		check(root.left, s, false);
		check(root.right, s, true);
		return s.isEmpty();
    }
    
    public void check(TreeNode root, Stack<Integer> s, boolean isRight) {
    
    	if (root == null) {
    		return;
    	}
    	check(root.left, s, isRight);
    	if (isRight) {
    		if (!s.isEmpty() && root.val == s.peek()) {
    			s.pop();
    		} else {
    			s.push(Integer.MIN_VALUE);
    			return;
    		}
    	} else {
    		s.push(root.val);
    	}
    	check(root.right, s, isRight);
    }
    
}
