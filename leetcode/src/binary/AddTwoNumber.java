package binary;

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
		ListNode pre = null;
		while (l1 != null && l2 != null) {
			l1.val += upgrade + l2.val;
			upgrade = l1.val / 10;
			l1.val = l1.val % 10;
			pre = l1;
			l1 = l1.next;
			l2 = l2.next;
		}
		ListNode p = (l1 == null) ? l2 : l1;
		pre.next = p;
		while (p != null && upgrade == 1) {
			p.val += upgrade;
			upgrade = p.val / 10;
			p.val = p.val % 10;
			pre = p;
			p = p.next;
		}
		if (p == null && upgrade == 1) {
			p = new ListNode(1);
			pre.next = p;
		}
		return re;
	}
}
