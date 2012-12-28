package tree;

/**
 * Maximum Depth of Binary Tree
 *
 */
public class MaximumDepth {
	public int maxDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }
}
