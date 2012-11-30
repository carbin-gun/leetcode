package tree;

import java.util.ArrayList;
import java.util.LinkedList;
/**
 * Different with the TreeLevelOrderI, here I use a flag node to spearate the level;
 * it seems working well.
 * @author kwwang
 *
 */

public class TreeLevelOrderII {
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
            if (next.val == Integer.MAX_VALUE) {
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
        ArrayList<ArrayList<Integer>> resultFinal = new ArrayList<ArrayList<Integer>>();
        for (int i = result.size() - 1; i >= 0; i--) {
            resultFinal.add(result.get(i));
        }
        return resultFinal;
    }
}
