package tree;

public class BTToLinkedList {
	public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root != null)
            flattened(root);
    }
    
    public TreeNode[] flattened(TreeNode root) {
        TreeNode[] re = new TreeNode[2];
        re[0] = root;
        re[1] = root;
        TreeNode[] r = null;
        TreeNode[] l = null;
        if (root.right != null) {
            r = flattened(root.right);
        }
        if (root.left != null) {
            l = flattened(root.left);
            root.left = null;
        }
        if (l != null) {
            re[1].right = l[0];
            re[1] = l[1];
        }
        if (r != null) {
            re[1].right = r[0];
            re[1] = r[1];
        }
        return re;
    }
}
