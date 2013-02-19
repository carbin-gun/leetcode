/**
 * Remove Duplicates from Sorted List II
 * 
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * 
 * For example, Given 1->2->3->3->4->4->5, return 1->2->5. Given 1->1->1->2->3,
 * return 2->3.
 * http://leetcode.com/questions/257/remove-duplicates-from-sorted-list-ii
 */
public class RemoveDuplicatesFromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (head == null || head.next == null) {
			return head;
		}

		ListNode ret = new ListNode(0);
		ListNode nonDup = ret;

		ListNode pre = head;
		ListNode cur = head.next;

		while (cur != null) {
			if (pre.val != cur.val) {
				nonDup.next = pre;
				nonDup = pre;
				pre = cur;
				cur = cur.next;
			} else {
				while (cur != null && cur.val == pre.val) {
					cur = cur.next;
				}
				pre = cur;
				if (cur != null) {
					cur = cur.next;
				}
			}
		}
		nonDup.next = pre;
		if (pre != null) {
			pre.next = null;
		}
		return ret.next;
	}
}
