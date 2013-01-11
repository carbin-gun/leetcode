/**
 * Flatten Binary Tree to Linked List
 * 
 * Given a binary tree, flatten it to a linked list in-place.
 * For example,
 * Given
 *        1
 *       / \
 *      2   5
 *     / \   \
 *    3   4   6
 * The flattened tree should look like:
 *  1
 *   \
 *    2
 *     \
 *      3
 *       \
 *        4
 *         \
 *          5
 *           \
 *            6
 * http://discuss.leetcode.com/questions/280/flatten-binary-tree-to-linked-list
 * Hints:
 * If you notice carefully in the flattened tree, each node's right child points 
 * to the next node of a pre-order traversal.
 */

/*
 * By returning a TreeNode, which the left is the first node of the list, 
 * and right is the last. Re-arrange the root base on the call return value
 * of it's children.
 */
public class FlattenBinaryTreetoLinkedList {
	public void flatten(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		flattenTree(root);
	}

	public TreeNode flattenTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode ret = new TreeNode(Integer.MIN_VALUE);
		TreeNode lc = flattenTree(root.left);
		TreeNode rc = flattenTree(root.right);
		ret.left = root;
		ret.right = root;
		// set the root both child to be null first.
		root.left = null; 
		root.right = null;
		if (lc != null) {
			ret.right.right = lc.left;
			ret.right = lc.right;
		}
		if (rc != null) {
			ret.right.right = rc.left;
			ret.right = rc.right;
		}
		return ret;
	}
}
