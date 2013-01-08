import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Binary Tree Zigzag Level Order Traversal
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. 
 * (ie, from left to right, then right to left for the next level and alternate between).

 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *    3
 *   / \
 *  9  20
 *    /  \
 *   15   7
 * return its zigzag level order traversal as:
 *
 * [
 * [3],
 * [20,9],
 * [15,7]]
 * 
 * http://leetcode.com/questions/52/binary-tree-zigzag-level-order-traversal
 *
 */

/*
 * Same like the level order, just keep one separator and a zigzag flag;
 */
public class BinaryTreeZigzagLevelOrderTraversal {
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return ret;
        }
        TreeNode sep = new TreeNode(Integer.MAX_VALUE);
        LinkedList<TreeNode> l = new LinkedList<TreeNode>();
        l.add(root);
        l.add(sep);
        boolean isZig = true;
        ArrayList<Integer> level = new ArrayList<Integer>();
        while (l.size() > 1) {
        	if (isZig) {
        		if (sep == l.peekFirst()) {
        			isZig = !isZig;
        			ret.add(level);
        			level = new ArrayList<Integer>();
        		} else {
        			TreeNode cur = l.pollFirst();
        			level.add(cur.val);
        			if (cur.left != null) {
        				l.add(cur.left);
        			}
        			if (cur.right != null) {
        				l.add(cur.right);
        			}
        		}
        	} else {
        		if (sep == l.peekLast()) {
        			isZig = !isZig;
        			ret.add(level);
        			level = new ArrayList<Integer>();
        		} else {
        			TreeNode cur = l.pollLast();
        			level.add(cur.val);
        			if (cur.right != null) {
        				l.addFirst(cur.right);
        			}
        			if (cur.left != null) {
        				l.addFirst(cur.left);
        			}
        		}
        	}
        }
        ret.add(level);
        return ret;
    }
	
	public static void main(String argv[]) {
		BinaryTreeZigzagLevelOrderTraversal zz = new BinaryTreeZigzagLevelOrderTraversal();
		System.out.print(zz.zigzagLevelOrder(new TreeNode(1)));
	}
}
