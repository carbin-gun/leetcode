package tree;

/**
 * Recover Binary Search Tree
 * 
 */
public class RecoverBinarySearchTree {
	public void recoverTree(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		TreeNode pre = new TreeNode(Integer.MIN_VALUE);
		TreeNode error = new TreeNode(Integer.MIN_VALUE);
		recoverTree(root, pre, error);
		error.val = error.left.val;
		error.left.val = error.right.val;
		error.right.val = error.val;
	}

	public void recoverTree(TreeNode root, TreeNode pre, TreeNode error) {
		if (root.left != null) {
			recoverTree(root.left, pre, error);
		}
		if (pre.val > root.val) {
			if (error.val == Integer.MIN_VALUE) {
				error.left = pre.left;
				error.right = root;
				error.val = 0;
			} else {
				error.right = root;
			}
		}
		pre.val = root.val;
		pre.left = root;
		if (root.right != null) {
			recoverTree(root.right, pre, error);
		}
	}
}
