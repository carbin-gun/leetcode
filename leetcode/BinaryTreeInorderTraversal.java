import java.util.ArrayList;
import java.util.Stack;

import tree.TreeNode;

/**
 * Binary Tree Inorder Traversal
 * 
 * Given a binary tree, return the inorder traversal of its nodes' values iteratively 
 * without using recursion.

 * For example:
 * Given binary tree {1,#,2,3},
 *  1
 *   \
 *    2
 *   /
 *  3
 * return [1,3,2].
 */

/*
 * The is a solution without recursion
 */
public class BinaryTreeInorderTraversal {
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> ret = new ArrayList<Integer>();
		if (root == null) {
			return ret;
		}
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode cur = root;
		while (true) {
			if (cur != null) {
				s.push(cur);
				cur = cur.left;
			} else if (!s.isEmpty()) {
				cur = s.pop();
				ret.add(cur.val);
				cur = cur.right;
			} else {
				break;
			}
		}
		return ret;
	}
}
