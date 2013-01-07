import tree.TreeNode;

/**
 * Balanced Binary Tree 
 * 
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 * http://discuss.leetcode.com/questions/276/balanced-binary-tree
 */

/*
 * If root is a balanced Binary Tree, then the child also be balanced Binary Tree.
 */

public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		return getHightIfBalanced(root) != -1;
	}

	public int getHightIfBalanced(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = getHightIfBalanced(root.left);
		int right = getHightIfBalanced(root.right);
		if (left == -1 || right == -1) {
			return -1;
		} else if (Math.abs(right - left) <= 1) {
			return Math.max(right, left) + 1;
		} else {
			return -1;
		}
	}
}
