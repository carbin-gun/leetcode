package list;

/**
 * Reverse Linked List II
 * http://leetcode.com/questions/267/reverse-linked-list-ii
 */
public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (head == null || m >= n) {
			return head;
		}
		ListNode re = new ListNode(Integer.MAX_VALUE);
		re.next = head;
		ListNode start = re;
		int counter = m;
		while (start.next != null && counter > 1) {
			start = start.next;
			counter--;
		}
		if (counter != 1) {
			return re.next;
		}
		counter = n - m;
		ListNode pre = start.next;
		ListNode cur = start.next.next;
		while (cur != null && counter > 0) {
			ListNode tmp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = tmp;
			counter--;
		}
		start.next.next = cur;
		start.next = pre;
		return re.next;
	}
}
