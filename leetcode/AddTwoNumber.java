import list.ListNode;

/**
 * Add Two Numbers You are given two linked lists representing two non-negative
 * numbers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 * http://discuss.leetcode.com/questions/189/add-two-numbers
 */

/*
 * The solution is to walk along one list, when either of the .next is null it stop, 
 * Plan to return l1 as the result, then, if l1.next == null, put l1.next = l2.next, 
 * otherwise do nothing. 
 * Be noticed that l1.next == null, the while breaks, but last l1 and l2, are currently not
 * be added. We need add l2.val to l1.val, and operated l1 to final. 
 */
public class AddTwoNumber {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (l1 == null && l2 == null) {
			return null;
		} else if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		}
		ListNode head = l1;
		int carry = 0;
		while (l1.next != null && l2.next != null) {
			int sum = l1.val + l2.val + carry;
			l1.val = sum % 10;
			carry = sum / 10;
			l1 = l1.next;
			l2 = l2.next;
		}

		if (l1.next == null) {
			l1.next = l2.next;
		}
		l1.val += l2.val; // this is where at first I put it into the above if.
		ListNode pre = l1;
		while (l1 != null) {
			int sum = l1.val + carry;
			l1.val = sum % 10;
			carry = sum / 10;
			pre = l1;
			l1 = l1.next;
		}
		if (carry != 0) {
			pre.next = new ListNode(carry);
		}
		return head;
	}
}
