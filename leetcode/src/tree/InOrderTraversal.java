package tree;
/**
 * Binary Tree Inorder Traversal
 */
import java.util.ArrayList;
import java.util.Stack;

public class InOrderTraversal {
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
        		s.push(current);
        		current = current.left;
        	} else {
        		if (!s.isEmpty()) {
        			current = s.pop();
        			al.add(current.val);
        			current = current.right;
        		} else {
        			flag = false;
        		}
        	}
        }
        return al;
    }
}
