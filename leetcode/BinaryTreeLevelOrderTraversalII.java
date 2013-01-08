import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Binary Tree Level Order Traversal II
 * 
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
 * (ie, from left to right, level by level from leaf to root).
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *   3
 *  / \
 * 9  20
 *   /  \
 *  15   7
 * return its bottom-up level order traversal as:
 * [[15,7]
 *  [9,20],
 *  [3]]
 * http://discuss.leetcode.com/questions/275/binary-tree-level-order-traversal-ii
 */

/*
 * Same method with the I. 
 */
public class BinaryTreeLevelOrderTraversalII {
	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        LinkedList<TreeNode> ll = new LinkedList<TreeNode>();
        if (root == null) {
            return result;
        }
        ll.add(root);
        TreeNode sep = new TreeNode(Integer.MAX_VALUE);
        ll.add(sep);
        ArrayList<Integer> level = new ArrayList<Integer>();
        while (!ll.isEmpty()) {
            TreeNode next = ll.pop();
            if (next == sep) {
                result.add(level);
                level = new ArrayList<Integer>();
                if (!ll.isEmpty())
                    ll.add(next);
            } else {
                level.add(next.val);
                if (next.left != null)
                    ll.add(next.left);
                if (next.right != null)
                    ll.add(next.right);
            }
        }
        Collections.reverse(result);
        return result;
    }
}
