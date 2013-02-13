/**
 * Populating Next Right Pointers in Each Node
 * 
 * Given a binary tree
 * 
 * Populate each next pointer to point to its next right node. If there
 * is no next right node, the next pointer should be set to NULL.
 * 
 * Initially, all next pointers are set to NULL.
 * 
 * Note:
 * 
 * You may only use constant extra space. You may assume that it is a perfect
 * binary tree (ie, all leaves are at the same level, and every parent has two
 * children). 
 * 
 * Given the following perfect binary tree,
 *         1
 *       /  \
 *      2    3
 *     / \  / \
 *    4  5  6  7
 * After calling your function, the tree should look like:
 *         1 -> NULL
 *       /  \
 *      2 -> 3 -> NULL
 *     / \  / \
 *    4->5->6->7 -> NULL
 * 
 */

public class PopulatingNextRightPointers {
	public void connect(TreeLinkNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null)
			return;
		if (root.left != null) {
			root.left.next = root.right;
			connect(root.left);
		}
		if (root.right != null) {
			if (root.next != null) {
				root.right.next = root.next.left;
			} else {
				root.right.next = null;
			}
			connect(root.right);
		}
	}
}
