package tree;

import java.util.LinkedList;
import java.util.ArrayList;

public class TreeLevelOrder {
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
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
