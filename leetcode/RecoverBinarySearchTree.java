import tree.TreeNode;

/**
 * Recover Binary Search Tree
 * 
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * 
 * Recover the tree without changing its structure.
 * 
 * Note: A solution using O(n) space is pretty straight forward. Could you
 * devise a constant space solution? confused what "{1,#,2,3}" means? > read
 * more on how binary tree is serialized on OJ.
 * 
 * 
 * OJ's Binary Tree Serialization: The serialization of a binary tree follows a
 * level order traversal, where '#' signifies a path terminator where no node
 * exists below.
 * 
 * Here's an example:
 * 
 *   1
 *  / \
 * 2   3
 *    /
 *   4
 *    \
 *     5
 * The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".
 * 
 * 
 * http://discuss.leetcode.com/questions/272/recover-binary-search-tree
 */
public class RecoverBinarySearchTree {
	public void recoverTree(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null) {
			return;
		}
		TreeNode err = new TreeNode(0);
		TreeNode pre = new TreeNode(Integer.MIN_VALUE);
		checkTree(err, pre, root);
		if (err.val == 1) {
			int tmp = err.left.val;
			err.left.val = err.right.val;
			err.right.val = tmp;
		}
		return;
	}

	public void checkTree(TreeNode err, TreeNode pre, TreeNode root) {
		if (root.left != null) {
			checkTree(err, pre, root.left);
		}
		if (pre.val > root.val) {
			if (err.val == 0) {
				err.val = 1;
				err.left = pre.left;
				err.right = root;
			} else {
				err.right = root;
			}
		}
		pre.val = root.val;
		pre.left = root;
		if (root.right != null) {
			checkTree(err, pre, root.right);
		}
	}
}
