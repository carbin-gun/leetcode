/**
 * Binary Tree Maximum Path Sum
 * Given a binary tree, find the maximum path sum. The path may start and end at any 
 * node in the tree.

 * For example:
 * Given the below binary tree,
 *      1
 *     / \
 *    2   3
 * Return 6.
 * http://discuss.leetcode.com/questions/288/binary-tree-maximum-path-sum
 */

/*
 * The solution is to get a method to return 2 value, one is current max path, one is cur
 * max single path,
 */
public class BinaryTreeMaximumPathSum {
	public int maxPathSum(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int[] ret;
		if (root == null) {
			return 0;
		}
		ret = maxPathSumCal(root);
		return ret[1];
	}

	public int[] maxPathSumCal(TreeNode root) {
		int[] ret = new int[2];
		ret[1] = Integer.MIN_VALUE; // have to set cur max to integer.MIN
		if (root == null) {
			return ret;
		}

		int[] left = maxPathSumCal(root.left);
		int[] right = maxPathSumCal(root.right);
		ret[0] = Math.max(root.val + right[0], root.val + left[0]);
		ret[0] = Math.max(ret[0], root.val);
		ret[1] = Math.max(left[1], right[1]);
		ret[1] = Math.max(ret[1], ret[0]);
		ret[1] = Math.max(ret[1], root.val + left[0] + right[0]);
		return ret;
	}
}
