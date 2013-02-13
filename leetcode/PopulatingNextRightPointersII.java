

import tree.TreeLinkNode;

/**
 * Populating Next Right Pointers in Each Node II Follow up for problem
 * "Populating Next Right Pointers in Each Node".
 * 
 * What if the given tree could be any binary tree? Would your previous solution
 * still work?
 * 
 * Note:
 * 
 * You may only use constant extra space. For example, Given the following
 * binary tree,
 * 
 *       1
 *      /  \
 *     2    3
 *    / \    \
 *   4   5    7
 * After calling your function, the tree should look like:
 *        1 -> NULL
 *      /  \
 *     2 -> 3 -> NULL
 *    / \    \
 *   4-> 5 -> 7 -> NULL
 */
public class PopulatingNextRightPointersII {
	public void connect(TreeLinkNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null) {
			return;
		}

		if (root.right != null) {
			root.right.next = findNext(root);
			connect(root.right);
		}

		if (root.left != null) {
			if (root.right != null) {
				root.left.next = root.right;
			} else {
				root.left.next = findNext(root);
			}
			connect(root.left);
		}
	}

	public TreeLinkNode findNext(TreeLinkNode root) {
		if (root.next == null) {
			return null;
		} else if (root.next.left != null) {
			return root.next.left;
		} else if (root.next.right != null) {
			return root.next.right;
		} else {
			return findNext(root.next);
		}
	}
}
