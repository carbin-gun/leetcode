/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path
 * could represent a number.
 * 
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * 
 * Find the total sum of all root-to-leaf numbers.
 * 
 * For example,
 *   1
 *  / \
 * 2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Return the sum = 12 + 13 = 25.
 * 
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */

public class SumRoottoLeafNumber {
	public int sumNumbers(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null) {
			return 0;
		}
		return sumNumbers(root, 0);
	}

	public int sumNumbers(TreeNode root, int sum) {
		int ret = 0;
		int newSum = sum * 10 + root.val;
		if (root.left == null && root.right == null) {
			return newSum;
		} else {
			if (root.left != null) {
				ret += sumNumbers(root.left, newSum);
			}
			if (root.right != null) {
				ret += sumNumbers(root.right, newSum);
			}
		}
		return ret;

	}
}
