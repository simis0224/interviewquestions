package List;

/**
	Given a sorted linked list, delete all nodes that have duplicate numbers, 
	leaving only distinct numbers from the original list.
	
	For example,
	Given 1->2->3->3->4->4->5, return 1->2->5.
	Given 1->1->1->2->3, return 2->3.
 */
public class RemoveDupFromSortedListII {
    public static class ListNode {
    	int val;
    	ListNode next;
    	ListNode(int x) {
    		val = x;
    		next = null;
    	}
    }
	
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
        	return head;
        }
        
        ListNode n = head;
        ListNode onlyOneNode = null;
        head = null;
        while(n != null) {
        	if(n.next != null && n.val == n.next.val) {
        		int tmp = n.val;
        		while(n != null && n.val == tmp) {
        			n = n.next;
        		}
        	} else {
        		// 1) next two elements are not the same 
        		// 2) only one node is in the list
            	if(onlyOneNode == null && 
            			((n.next != null && n.next.val != n.val) || n.next == null)) {
            		head = n;
            		onlyOneNode = n;
            	} else {
	        		onlyOneNode.next = n;
	        		onlyOneNode = onlyOneNode.next;
            	}
            	n = n.next;
        	}
        }
        if(onlyOneNode != null) {
        	onlyOneNode.next = null;
        }
        return head;
    }
    
    public static void main(String[] args) {
    	ListNode n1 = new ListNode(1);
    	ListNode n2 = new ListNode(1);
    	n1.next = n2;
    	deleteDuplicates(n1);
    }
}
