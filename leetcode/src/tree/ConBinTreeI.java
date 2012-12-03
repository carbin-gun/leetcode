package tree;

/**
 * Construct Binary Tree from Inorder and Postorder Traversal
 * use the recursive, to build up, the last item of postorder can separate inorder to left and right
 * key is the left and right can easily be separated in the postorder by the number of items in left 
 * and right, which we already know by separating of inorder.
 * 
 */
public class ConBinTreeI {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
    	// Start typing your Java solution below
		// DO NOT write main() function
		if (inorder.length == 0 || inorder.length != postorder.length) {
    	    return null;   
		}
        else 
            return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
	}
    
    public TreeNode buildTree(int[] inorder, int[] postorder, int s1, int e1, int s2, int e2) {
        if (s1 == e1) {
            TreeNode root = new TreeNode(inorder[s1]);
            return root;
        }
        TreeNode root = new TreeNode(postorder[e2]);
        int sep = s1;
        while (inorder[sep] != root.val) {
            sep++;
        }
        if (sep > s1) {
            root.left = buildTree(inorder, postorder, s1, sep - 1, s2, s2 + sep - 1 - s1);
        }
        if (sep < e1) {
            root.right = buildTree(inorder, postorder, sep + 1, e1, e2 - e1 + sep, e2 - 1);
        }
        return root;
    }
	
	public static void main(String argv[]) {
		int[] a = {3, 2, 1};
		int[] b = {3, 2, 1};
		new ConBinTreeI().buildTree(a, b);
	}
}
