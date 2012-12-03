package tree;

/**
 * 
 * Convert Sorted Array to Binary Search Tree
 */
public class ArrayToBST {
	public TreeNode sortedArrayToBST(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (num.length == 0) {
            return null;
        }
        return sortedArrayToBST(num, 0, num.length - 1);
    }
    
    public TreeNode sortedArrayToBST(int[] num, int s, int e) {
        if (s == e) {
            TreeNode root = new TreeNode(num[s]);
            return root;
        }
        int sep = s + (e - s + 1) / 2;
        TreeNode root = new TreeNode(num[sep]);
        if (sep > s) {
            root.left = sortedArrayToBST(num, s, sep - 1);
        }
        if (sep < e) {
            root.right = sortedArrayToBST(num, sep + 1, e);
        }
        return root;
    }
}
