package List;
/**
	Given a sorted linked list, delete all duplicates such that each element appear only once.
	
	For example,
	Given 1->1->2, return 1->2.
	Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoveDupFromSortedList {
    public static class ListNode {
    	int val;
    	ListNode next;
    	ListNode(int x) {
    		val = x;
    		next = null;
    	}
    }
    public ListNode deleteDuplicates(ListNode head) {
    	if(head == null) {
    		return head;
    	}
    	
    	ListNode n1 = head;
    	ListNode pre = null;
    	ListNode firstNode = head;
    	while(n1 != null) {
			if(pre == null) {
				pre = head;
			} else if(n1.val != pre.val) {
    			firstNode.next = n1;
    			firstNode = firstNode.next;
    		}
    		pre = n1;
    		n1 = n1.next;
    	}
    	// don't forget to set next of the last node to null
    	firstNode.next = null;
    	return head;
    }
}
