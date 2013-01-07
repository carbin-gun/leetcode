package tree;

import list.ListNode;


/**
 * Swap Nodes in Pairs
 * http://discuss.leetcode.com/questions/205/swap-nodes-in-pairs
 */
public class SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (head == null) {
			return head;
		}
		ListNode re = new ListNode(Integer.MAX_VALUE);
		re.next = head;
		ListNode pre = re;
		ListNode cur = head;
		while (cur != null && cur.next != null) {
			pre.next = cur.next;
			cur.next = cur.next.next;
			pre.next.next = cur;
			pre = cur;
			cur = cur.next;
		}
		return re.next;
	}
}
