package tree;
/**
 * Binary Tree Maximum Path Sum
 *
 */
public class MaxTreePathSum {
	public int maxPathSum(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int re[] = maxFindMax(root);
        return re[1];
    }
    
    public int[] maxFindMax(TreeNode root) {
        int re[] = new int[2];
        if (root == null) {
            re[0] = Integer.MIN_VALUE;
            re[1] = Integer.MIN_VALUE;
        } else {
            int[] left = maxFindMax(root.left);
            int[] right = maxFindMax(root.right);
            re[0] = left[0] > 0 ? (left[0] + root.val) : root.val;
            // Following line is good point of how to deal the MAX and MIN out of bound issue.
            re[0] = re[0] - root.val> right[0] ? re[0] : (right[0] + root.val); 
            re[1] = left[1] > right[1] ? left[1] : right[1];
            int currentMax = root.val;
            if (left[0] > 0)
                currentMax += left[0];
            if (right[0] > 0)
                currentMax += right[0];
            if (currentMax > re[1])
                re[1] = currentMax;
        }
        return re;
    }
}
