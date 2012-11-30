package tree;
/**
 * Balanced Binary Tree
 * It will caculate the height as well, if the height is -1, means that the subtree is
 * no longer balanced.
 */

public class BalancedBinaryTree {
	/**
	 * Definition for binary tree public class TreeNode { int val; TreeNode
	 * left; TreeNode right; TreeNode(int x) { val = x; } }
	 */

	public boolean isBalanced(TreeNode root) {
    	// Start typing your Java solution below
		// DO NOT write main() function
		return getHightIfBalanced(root) != -1;
	}

	public int getHightIfBalanced(TreeNode root) {
		int l = 0;
		int r = 0;
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
		r = getHightIfBalanced(root.right);
		l = getHightIfBalanced(root.left);
		if (l == -1 || r == -1)
			return -1;
		if (Math.abs(l - r) > 1) {
			return -1;
		} else {
			return l > r ? l + 1 : r + 1;
		}
	}
}
