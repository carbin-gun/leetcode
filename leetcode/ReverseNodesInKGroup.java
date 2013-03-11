/**
 * Reverse Nodes in k-Group
 * 
 * Given a linked list, reverse the nodes of a linked list k at a time and
 * return its modified list.
 * 
 * If the number of nodes is not a multiple of k then left-out nodes in the end
 * should remain as it is.
 * 
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * 
 * Only constant memory is allowed.
 * 
 * For example, Given this linked list: 1->2->3->4->5
 * 
 * For k = 2, you should return: 2->1->4->3->5
 * 
 * For k = 3, you should return: 3->2->1->4->5
 * 
 * 
 * http://discuss.leetcode.com/questions/206/reverse-nodes-in-k-group
 * 
 */
public class ReverseNodesInKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (head == null || k == 1) {
			return head;
		}
		ListNode ret = new ListNode(0);
		ret.next = head;
		ListNode guider = head;
		ListNode lastEnd = ret;
		while (guider != null) {
			int counter = k;
			while (guider != null && counter > 0) {
				guider = guider.next;
				counter--;
			}
			if (counter == 0) {
				ListNode pre = lastEnd.next;
				ListNode cur = pre.next;
				while (cur != guider) {
					ListNode tmp = cur.next;
					cur.next = pre;
					pre = cur;
					cur = tmp;
				}
				ListNode tmp = lastEnd.next;
				tmp.next = cur;
				lastEnd.next = pre;
				lastEnd = tmp;
			}
		}
		return ret.next;
	}
}
