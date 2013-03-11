/**
 * Rotate List
 * 
 * Given a list, rotate the list to the right by k places, where k is
 * non-negative.
 * 
 * For example: Given 1->2->3->4->5->NULL and k = 2, return 4->5->1->2->3->NULL.
 * 
 * http://discuss.leetcode.com/questions/238/rotate-list
 */
public class RotateList {
	public ListNode rotateRight(ListNode head, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (head == null || head.next == null)
			return head;
		int k = n;
		ListNode ret = new ListNode(0);
		ret.next = head;
		ListNode prob = ret;
		while (prob.next != null && k > 0) {
			prob = prob.next;
			k--;
		}
		if (k != 0) {
			k = n % (n - k);
			prob = ret;
			while (k > 0) {
				prob = prob.next;
				k--;
			}
		}
		if (prob.next == null) {
			return head;
		}

		ListNode newHead = ret;
		while (prob.next != null) {
			newHead = newHead.next;
			prob = prob.next;
		}
		prob.next = head;
		head = newHead.next;
		newHead.next = null;
		return head;
	}

}
