import java.util.ArrayList;
import java.util.Stack;

/**
 * Binary Tree Postorder Traversal
 *
 */
public class BinaryTreePostorderTraversal {
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if (root == null) {
            return ret;
        }
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode cur = root;
        TreeNode pre = root;
        s.push(root);
        while (!s.isEmpty()) {
        	cur = s.peek();
        	if (cur == pre || cur == pre.left || cur == pre.right) {
        		if (cur.left != null) {
        			s.push(cur.left);
        		} else if (cur.right != null) { // push left then do nothing on right
        			s.push(cur.right);
        		} else {
        			ret.add(s.pop().val);
        		}
        	} else if (cur.left == pre) {
        		if (cur.right != null) {
        			s.push(cur.right);
        		} else {
        			ret.add(s.pop().val);
        		}
        	} else if (cur.right == pre) {
        		ret.add(s.pop().val);
        	}
        	pre = cur;
        }
        return ret;
    }
}
