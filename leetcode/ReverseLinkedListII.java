/**
 * Reverse Linked List II
 * 
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * 
 * For example: Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * 
 * return 1->4->3->2->5->NULL.
 * 
 * Note: Given m, n satisfy the following condition: 1 ² m ² n ² length of list.
 * 
 * http://leetcode.com/questions/267/reverse-linked-list-ii
 */
public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (head == null || m == n) {
			return head;
		}
		ListNode ret = new ListNode(0);
		ret.next = head;
		ListNode start = ret;
		int counter = m;
		while (start.next != null && counter > 1) {
			start = start.next;
			counter--;
		}
		if (counter > 1) {
			return head;
		}
		ListNode end = start.next;
		ListNode cur = end.next;
		counter = n - m;
		while (cur != null && counter > 0) {
			ListNode tmp = cur.next;
			cur.next = start.next;
			start.next = cur;
			end.next = tmp;
			cur = tmp;
			counter--;
		}
		return ret.next;
	}
}
