/**
 * Remove Nth Node From End of List Given a linked list, remove the nth node
 * from the end of list and return its head.
 * 
 * For example,
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5.
 * 
 * http://leetcode.com/questions/200/remove-nth-node-from-end-of-list
 * 
 */

public class RemoveNthNodeFromEndofList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ListNode ret = new ListNode(0);
		ret.next = head;
		ListNode prob = ret;
		int i = n;
		while (prob != null && i >= 0) {
			prob = prob.next;
			i--;
		}
		if (i >= 0) {
			return head;
		}
		ListNode cur = ret;
		while (prob != null) {
			cur = cur.next;
			prob = prob.next;
		}
		cur.next = cur.next.next;
		return ret.next;
	}
}
