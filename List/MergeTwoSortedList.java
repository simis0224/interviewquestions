package List;
/**
	Merge two sorted linked lists and return it as a new list. 
	The new list should be made by splicing together the nodes of the first two lists.
 */

public class MergeTwoSortedList {
    public static class ListNode {
    	int val;
    	ListNode next;
    	ListNode(int x) {
    		val = x;
    		next = null;
    	}
    }
    
    ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	if(l1 == null) {
    		return l2;
    	}
    	
    	if(l2 == null) {
    		return l1;
    	}
    	
    	ListNode head = null;
    	ListNode last = null;
    	while(l1 != null && l2 != null) {
    		ListNode newNode = l1.val < l2.val ? l1 : l2;
    		if(head == null) {
    			head = newNode;
    			last = newNode;
    		} else {
    			last.next = newNode;
    			last = last.next;
    		}
    		if(l1.val < l2.val) {
    			l1 = l1.next;
    		} else {
    			l2 = l2.next;
    		}
    	}
    	
    	if(l1 == null) {
    		last.next = l2;
    	} 
    	
    	if(l2 == null) {
    		last.next = l1;
    	}
    	
    	return head;
    }
    
}
