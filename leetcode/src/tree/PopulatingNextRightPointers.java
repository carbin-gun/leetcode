package tree;

/**
 * Populating Next Right Pointers in Each Node
 *
 */
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
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
