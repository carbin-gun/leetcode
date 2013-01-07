import java.util.LinkedList;
import java.util.ArrayList;

/**
 * Binary Tree Level Order Traversal
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *   3
 *  / \
 * 9  20
 *   /  \
 *  15   7
 * return its level order traversal as:
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */

/*
 * Two solutions are provided here, one is using one sep to separated the levels, another
 * is using two linked list to do it. Same idea.
 */
public class BinaryTreeLevelOrderTraversal {
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		TreeNode sep = new TreeNode(Integer.MAX_VALUE);
		LinkedList<TreeNode> list = new LinkedList<TreeNode>();
		if (root == null) {
			return ret;
		}
		list.add(root);
		list.add(sep);
		ArrayList<Integer> level = new ArrayList<Integer>();
		while (list.size() > 1) {
			TreeNode cur = list.poll();
			if (cur == sep) {
				list.add(cur);
				ret.add(level);
				level = new ArrayList<Integer>();
			} else {
				level.add(cur.val);
				if (cur.left != null) {
					list.add(cur.left);
				}
				if (cur.right != null) {
					list.add(cur.right);
				}
			}
		}
		ret.add(level);
		return ret;
	}

	public ArrayList<ArrayList<Integer>> levelOrderNoSep(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		LinkedList<TreeNode> l1 = new LinkedList<TreeNode>();
		LinkedList<TreeNode> l2 = new LinkedList<TreeNode>();
		ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
		if (root == null) {
			return al;
		}
		l1.add(root);
		ArrayList<Integer> level = new ArrayList<Integer>();
		while (!l1.isEmpty() || !l2.isEmpty()) {
			if (!l1.isEmpty()) {
				TreeNode current = l1.pop();
				if (current.left != null)
					l2.add(current.left);
				if (current.right != null)
					l2.add(current.right);
				level.add(current.val);
			} else {
				LinkedList<TreeNode> tmp = l1;
				l1 = l2;
				l2 = tmp;
				al.add(level);
				level = new ArrayList<Integer>();
			}
		}
		al.add(level);
		return al;
	}
}
