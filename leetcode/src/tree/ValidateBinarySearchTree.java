package tree;

/**
 * Validate Binary Search Tree
 * http://discuss.leetcode.com/questions/47/validate-binary-search-tree
 */
public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null) {
			return true;
		}
		return ValidBST(root).val == Integer.MAX_VALUE;
	}

	public TreeNode ValidBST(TreeNode root) {
		TreeNode left = null;
		TreeNode right = null;
		if (root.left != null) {
			left = ValidBST(root.left);
		}
		if (root.right != null) {
			right = ValidBST(root.right);
		}
		TreeNode re = new TreeNode(Integer.MAX_VALUE);
		if (left == null) {
			re.left = root;
		} else {
			if (left.val != 0 && left.right.val < root.val) {
				re.left = left.left;
			} else {
				re.val = 0;
			}
		}
		if (right == null) {
			re.right = root;
		} else {
			if (right.val != 0 && root.val < right.left.val) {
				re.right = right.right;
			} else {
				re.val = 0;
			}
		}
		return re;
	}
}
