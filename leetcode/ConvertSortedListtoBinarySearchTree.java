/**
 * Convert Sorted List to Binary Search Tree Given a singly linked list where
 * elements are sorted in ascending order, convert it to a height balanced BST.
 * 
 * http://discuss.leetcode.com/questions/112/convert-sorted-list-to-binary-search-tree
 */

/*
 * Recursive
 */
public class ConvertSortedListtoBinarySearchTree {
	public TreeNode sortedListToBST(ListNode head) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (head == null) {
			return null;
		}
		return sortedListToBST(head, null);
	}

	public TreeNode sortedListToBST(ListNode start, ListNode end) {
		ListNode mid = start;
		ListNode prob = start;
		while (prob != end && prob.next != end) {
			mid = mid.next;
			prob = prob.next.next;
		}
		TreeNode root = new TreeNode(mid.val);
		if (start != mid) {
			root.left = sortedListToBST(start, mid);
		}
		if (mid.next != end) {
			root.right = sortedListToBST(mid.next, end);
		}
		return root;
	}
}
