package tree;

/**
 * Construct Binary Tree from Preorder and Inorder Traversal 
 *
 */
public class ConBinTreeII {
	 public TreeNode buildTree(int[] preorder, int[] inorder) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        if (preorder.length == 0 || preorder.length != inorder.length) {
	            return null;
	        }
	        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
	    }
	    
	    public TreeNode buildTree(int[] preorder, int[] inorder, int s1, int e1, int s2, int e2) {
	        if (s1 == e1) {
	            TreeNode root = new TreeNode(preorder[s1]);
	            return root;
	        }
	        TreeNode root = new TreeNode(preorder[s1]);
	        int sep = s2;
	        while (root.val != inorder[sep]) {
	            sep++;
	        }
	        if (sep > s2) {
	            root.left = buildTree(preorder, inorder, s1 + 1, s1 + 1 + sep - 1 - s2, s2, sep - 1);
	        }
	        if (sep < e2) {
	            root.right = buildTree(preorder, inorder, s1 + 1 + sep - s2, e1, sep + 1, e2);
	        }
	        return root;
	    }
}
