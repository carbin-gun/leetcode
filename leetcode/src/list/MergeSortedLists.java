package list;

import java.util.ArrayList;

/**
 * Merge k Sorted Lists and Merge 2 sorted Lists
 * 
 */

public class MergeSortedLists {
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (lists.size() == 0) {
			return null;
		} else if (lists.size() == 1) {
			return lists.get(0);
		}
		ListNode newHead = lists.get(0);
		for (int i = 1; i < lists.size(); i++) {
			newHead = mergeTwoLists(newHead, lists.get(i));
		}
		return newHead;
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l2 == null) {
			return l1;
		}
		if (l1 == null) {
			return l2;
		}
		ListNode newHead = l1;
		ListNode fCur = l1;
		ListNode eCur = l2;
		ListNode ePre = null;
		while (eCur != null && eCur.val < l1.val) {
			ePre = eCur;
			eCur = eCur.next;
		}
		if (ePre != null) {
			ePre.next = fCur;
			newHead = l2;
		}
		
		while (fCur.next != null && eCur != null) {
			if (fCur.next.val < eCur.val) {
				fCur = fCur.next;
			} else {
				ListNode tmp = eCur;
				eCur = eCur.next;
				tmp.next = fCur.next;
				fCur.next = tmp;
				fCur = fCur.next;
			}
		}

		if (fCur.next == null) {
			fCur.next = eCur;
		}
		return newHead;

	}
}
