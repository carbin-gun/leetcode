package tree;

/**
 * Populating Next Right Pointers in Each Node II 
 *
 */
public class PopulatingNextRightPointersII {
	public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null)
            return;
        
        if (root.right != null) {
            root.right.next = findRNext(root);
        	connect(root.right);
        }
        if (root.left != null) {
        	root.left.next = findLNext(root);
        	connect(root.left);
        }
    }
    
    public TreeLinkNode findRNext(TreeLinkNode root) {
    	while (root.next != null) {
    		if (root.next.left != null)
    			return root.next.left;
    		if (root.next.right != null)
    			return root.next.right;
    		root = root.next;
    	}
    	return null;
    }
    
    public TreeLinkNode findLNext(TreeLinkNode root) {
    	if (root.right != null) 
    		return root.right;
    	return findRNext(root);
    }
}
