package list;

/**
 * Remove Duplicates from Sorted List
 * http://leetcode.com/questions/258/remove-duplicates-from-sorted-list
 */
public class RemoveDuplicatesFromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null || head.next == null) {
        	return head;
        }
        ListNode unDup = head;
        ListNode cur = head.next;
        while (cur != null) {
        	if (unDup.val != cur.val) {
        		unDup.next = cur;
        		unDup = cur;
        	}
        	cur = cur.next;
        }
        unDup.next = null;
        return head;
    }
	
}
