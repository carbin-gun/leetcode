/**
 * Minimum Depth of Binary Tree
 * 
 * Given a binary tree, find its minimum depth.
 * 
 * The minimum depth is the number of nodes along the shortest path from the
 * root node down to the nearest leaf node.
 */

/*
 * Take care of the based case, is different from the max.
 */
public class MinimumDepthofBinaryTree {
	public int minDepth(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}
		int ret = Integer.MAX_VALUE;
		if (root.left != null) {
			ret = Math.min(ret, minDepth(root.left) + 1);
		}
		if (root.right != null) {
			ret = Math.min(ret, minDepth(root.right) + 1);
		}
		return ret;
	}
}
