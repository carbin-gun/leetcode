/**
 * Binary Tree Maximum Path Sum Given a binary tree, find the maximum path sum.
 * The path may start and end at any node in the tree.
 * 
 * For example: Given the below binary tree, 1 / \ 2 3 Return 6.
 * http://discuss.leetcode.com/questions/288/binary-tree-maximum-path-sum
 */

/*
 * The solution is to get a method to return 2 value, one is current max path,
 * one is cur max single path,
 */
public class BinaryTreeMaximumPathSum {
	public int maxPathSum(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null) {
			return 0;
		}
		int[] maxSum = new int[1];
		maxSum[0] = Integer.MIN_VALUE;
		maxPathSum(root, maxSum);
		return maxSum[0];
	}

	public int maxPathSum(TreeNode root, int[] maxSum) {
		if (root == null) {
			return 0;
		}
		int left = maxPathSum(root.left, maxSum);
		int right = maxPathSum(root.right, maxSum);
		int ret = root.val;
		maxSum[0] = maxSum[0] > ret + left + right ? maxSum[0] : ret + left
				+ right;
		ret = left > right ? ret + left : ret + right;
		return ret > 0 ? ret : 0;

	}
}
