package binary;

import list.ListNode;
/**
 * Add Two Numbers
 * walk start from any list, and add sum to list l1, until one of them are ended, then
 * if the ended one is the the sum, then we point l1Pre -> another list, make sure that 
 * you reset the list. Here seems I missed that part.
 */

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */
public class AddTwoNumber {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		int upgrade = 0;
		ListNode re = l1;
		ListNode l1Pre = null;
		ListNode l2Pre = null;
		while (l1 != null && l2 != null) {
			l1.val += upgrade + l2.val;
			upgrade = l1.val / 10;
			l1.val = l1.val % 10;
			l1Pre = l1;
			l2Pre = l2;
			l1 = l1.next;
			l2 = l2.next;
		}
		ListNode p = null;
		if (l1Pre.next == null) {
			p = l2;
			l2Pre.next = null;
		} else {
			p = l1;
		}
		l1Pre.next = p;
		while (p != null && upgrade == 1) {
			p.val += upgrade;
			upgrade = p.val / 10;
			p.val = p.val % 10;
			l1Pre = p;
			p = p.next;
		}
		if (p == null && upgrade == 1) {
			p = new ListNode(1);
			l1Pre.next = p;
		}
		return re;
	}
}
