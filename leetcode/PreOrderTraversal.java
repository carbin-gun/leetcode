

import java.util.ArrayList;
import java.util.Stack;

import tree.TreeNode;

public class PreOrderTraversal {
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
		ArrayList<Integer> al = new ArrayList<Integer>();
		Stack<TreeNode> s = new Stack<TreeNode>();
        if (root == null) {
        	return al;
        }
        TreeNode current = root;
        boolean flag = true;
        while(flag) {
        	if (current != null) {
        		al.add(current.val);
        		s.push(current);
        		current = current.left;
        	} else {
        		if (!s.isEmpty()) {
        			current = s.pop();
        			current = current.right;
        		} else {
        			flag = false;
        		}
        	}
        }
        return al;
    }
}
