

import java.util.LinkedList;
import java.util.Stack;

import tree.TreeNode;

/**
 * Symmetric Tree
 * http://leetcode.com/questions/274/symmetric-tree
 * Given a binary tree, check whether it is a mirror of itself
 * (ie, symmetric around its center).
 */
public class SymmetricTree {
	
	public boolean isSymmetricRecusive(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if (root == null) {
			return true;
		}
		return isSymmetric(root.left, root.right);
    }
    
    public boolean isSymmetric(TreeNode left, TreeNode right) {
    	if (left == null && right == null) {
    		return true;
    	} else if (left == null || right == null) {
    		return false;
    	}
    	if (left.val != right.val) {
    		return false;
    	} else {
    		return isSymmetric(left.right, right.left) && isSymmetric(right.right, left.left);
    	}
    }
    
}
