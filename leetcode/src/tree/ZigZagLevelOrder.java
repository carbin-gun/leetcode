package tree;

import java.util.ArrayList;
import java.util.LinkedList;

public class ZigZagLevelOrder {
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> ll = new LinkedList<TreeNode>();
        TreeNode sep = new TreeNode(Integer.MAX_VALUE);
        boolean isZig = true;
        ll.add(root);
        ll.push(sep);
        ArrayList<Integer> level = new ArrayList<Integer>();
        while (!ll.isEmpty()) {
            if (isZig) {
                TreeNode cur = ll.removeLast();
                if (cur != sep) {
                    level.add(cur.val);
                    if (cur.left != null)
                        ll.push(cur.left);
                    if (cur.right != null)
                        ll.push(cur.right);
                    }
                else {
                    if (!ll.isEmpty())
                        ll.add(cur);
                    result.add(level);
                    level = new ArrayList<Integer>();
                    isZig = false;
                }
            } else {
                TreeNode cur = ll.pop();
                if (cur != sep) {
                    level.add(cur.val);
                    if (cur.right != null)
                        ll.add(cur.right);
                    if (cur.left != null)
                        ll.add(cur.left);
                } else {
                    if (!ll.isEmpty())
                        ll.push(cur);
                    result.add(level);
                    level = new ArrayList<Integer>();
                    isZig = true;
                }
            }
        }
        return result;
    }
	
	public static void main(String argv[]) {
		ZigZagLevelOrder zz = new ZigZagLevelOrder();
		System.out.print(zz.zigzagLevelOrder(new TreeNode(1)));
	}
}
