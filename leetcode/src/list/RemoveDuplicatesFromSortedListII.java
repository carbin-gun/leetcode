package list;

/**
 * Remove Duplicates from Sorted List II
 * http://leetcode.com/questions/257/remove-duplicates-from-sorted-list-ii
 * 主要的想法是 新建一个空节点，用他的next来连已经确定的不重复的节点，节点是否重复的判断是：
 * 1，备选不重复节点是否和当前节点的值不同，不同则，如果pre节点与备选节点相同，或者pre节点和备选节点的值
 * 相等，则备选节点加到确定不重复的链表中，当前节点变为备选节点。
 * 2. 如果cur的值与备选不同，但是pre的值与备选相同，则直接设置备选为cur，不加备选如确定不同链表
 * 3. 如果备选节点的值与当前节点一致，则直接往下
 */
public class RemoveDuplicatesFromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (head == null || head.next == null) {
			return head;
		}
		ListNode re = new ListNode(Integer.MAX_VALUE);
		ListNode noDup = re;
		ListNode dupCheck = head; 
		ListNode pre = head;
		ListNode cur = head.next;
		while (cur != null) {
			if (dupCheck.val != cur.val) {
				if (dupCheck == pre || dupCheck.val != pre.val) {
					noDup.next = dupCheck;
					noDup = noDup.next;
				} 
				dupCheck = cur;
			}
			pre = cur;
			cur = cur.next;
		}
		if (dupCheck == pre || dupCheck.val != pre.val) {
			noDup.next = dupCheck;
			noDup = noDup.next;
		}
		return re.next;
	}
}
