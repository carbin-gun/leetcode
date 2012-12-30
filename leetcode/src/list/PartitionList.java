package list;

/**
 * Partition List
 * 
 */
public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (head == null || head.next == null) {
			return head;
		}
		ListNode sep = null;
		ListNode newHead = head;
		while (head != null && head.val < x) {
			sep = head;
			head = head.next;
		}
		if (head == null) {
			return newHead;
		}
		ListNode pre = head;
		head = head.next;
		while (head != null) {
			if (head.val >= x) {
				pre = head;
				head = head.next;
			} else {
				pre.next = head.next;
				if (sep != null) {
					head.next = sep.next;
					sep.next = head;
					sep = sep.next;
				} else {
					head.next = newHead;
					newHead = head;
					sep = head;
				}
				head = pre.next;
			}
		}
		return newHead;
	}
}
