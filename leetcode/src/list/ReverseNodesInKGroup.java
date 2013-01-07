package list;

/**
 * Reverse Nodes in k-Group
 * http://leetcode.com/questions/206/reverse-nodes-in-k-group
 *
 */
public class ReverseNodesInKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode re = new ListNode(Integer.MAX_VALUE);
        re.next = head;
        ListNode guider = re.next;
        ListNode lastEnd = re;
        while (guider != null) {
            int counter = k;
        	while (guider != null && counter > 0) {
        		guider = guider.next;
        		counter--;
        	}
        	if (counter == 0) {
        		ListNode pre = lastEnd.next;
        		ListNode cur = lastEnd.next.next;
        		counter = k;
        		while (counter > 1) {
        			ListNode tmp = cur.next;
        			cur.next = pre;
        			pre = cur;
        			cur = tmp;
        			counter--;
        		}
        		ListNode tmp = lastEnd.next;
        		lastEnd.next = pre;
        		lastEnd = tmp;
                lastEnd.next = guider; // take care here. be sure to set this value.
        	}
        }
        return re.next;
    }
}
