import java.util.ArrayList;

import list.ListNode;

/**
 * Merge k Sorted Lists 
 * 
 * Merge k sorted linked lists and return it as one sorted
 * list. Analyze and describe its complexity.
 * 
 * http://discuss.leetcode.com/questions/204/merge-k-sorted-lists
 */

/*
 * Merge k sorted list is no way to do it quickly, just merge one by one, 
 * It takes O(m), where m is the sum of nodes in all the list.
 */
public class MergeSortedLists {
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (lists.size() == 0) {
			return null;
		}
		ListNode ret = new ListNode(Integer.MAX_VALUE);
		ret.next = lists.get(0);
		for (int i = 1; i < lists.size(); i++) {
			ret.next = mergeTwoList(ret.next, lists.get(i));
		}
		return ret.next;
	}

	public ListNode mergeTwoList(ListNode a, ListNode b) {
		ListNode ret = new ListNode(Integer.MAX_VALUE);
		ret.next = a;
		ListNode pre = ret;
		ListNode merger = b;
		while (pre.next != null && merger != null) {
			if (pre.next.val > merger.val) {
				ListNode tmp = merger;
				merger = merger.next;
				tmp.next = pre.next;
				pre.next = tmp;
				pre = pre.next;
			} else {
				pre = pre.next;
			}
		}
		if (pre.next == null) {
			pre.next = merger;
		}
		return ret.next;
	}
}
