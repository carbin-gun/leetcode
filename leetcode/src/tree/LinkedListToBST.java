package tree;

import list.ListNode;

/**
 * Convert Sorted List to Binary Search Tree 
 *
 */
public class LinkedListToBST {
	public TreeNode sortedListToBST(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null) {
            return null;
        }
        return sortedListToBST(head, null);
    }
    
    public TreeNode sortedListToBST(ListNode s, ListNode e) {
        if(s.next == e) {
            TreeNode root = new TreeNode(s.val);
            return root;
        }
        ListNode slow = s;
        ListNode faster = s;
        while(faster.next != e && faster.next.next != e) {
            slow = slow.next;
            faster = faster.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        if (slow != s) {
            root.left = sortedListToBST(s, slow);
        }
        if (slow != e) {
            root.right = sortedListToBST(slow.next, e);
        }
        return root;
    } 
    
    public static void main(String argv[]) {
    	ListNode a = new ListNode(1);
    	a.next = new ListNode(3);
    	new LinkedListToBST().sortedListToBST(a);
    }
}
