package list;

/**
 * Rotate List
 * http://leetcode.com/questions/238/rotate-list
 */
public class RotateList {
	public ListNode rotateRight(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode first = head;
        ListNode second = head;
        while (n > 0) {
        	n--;
        	if (first == null);
        		first = head;
        	first = first.next;
        }
        if (first == null) {
        	return head;
        }
        while (first.next != null) {
        	first = first.next;
        	second = second.next;
        }
        first.next = head;
        head = second.next;
        second.next = null;
		return head;       
    }

}
