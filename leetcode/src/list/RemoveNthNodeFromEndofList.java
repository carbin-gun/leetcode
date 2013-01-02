package list;

/**
 * Remove Nth Node From End of List
 * http://leetcode.com/questions/200/remove-nth-node-from-end-of-list
 * 
 */
public class RemoveNthNodeFromEndofList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (head == null) {
			return head;
		}
		ListNode pre = head;
		ListNode probe = head;

		while (probe.next != null && n > 0) {
			probe = probe.next;
			n--;
		}
		if (n == 1) {
			return head.next;
		}
		while (probe.next != null) {
			probe = probe.next;
			pre = pre.next;
		}
		pre.next = pre.next.next;
		return head;
	}
}
