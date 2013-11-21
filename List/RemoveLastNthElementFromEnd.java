package List;

/**
	Given a linked list, remove the nth node from the end of list and return its head.
	
	For example,
	
	   Given linked list: 1->2->3->4->5, and n = 2.
	
	   After removing the second node from the end, the linked list becomes 1->2->3->5.
	Note:
	Given n will always be valid.
	Try to do this in one pass.
 */

public class RemoveLastNthElementFromEnd {
	
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode t = head;
        ListNode k = null;
        
        if(head == null || (head.next == null && n == 1)) {
        	return null;
        }
        
        int count = 0;
        while(t != null) {
        	t = t.next;
        	if(count == n) {
        		k = head;
        	} else if(count > n) {
        		k = k.next;
        	}
        	count++;
        }
        
        // the first element is the one to remove
        if(k == null && count == n) {
        	return head.next;
        }
        
        if(k != null) {
        	k.next = k.next.next;
        }
        
        return head;
    }
    
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
       }
   }
    
    public static void main(String [] args) {
    	ListNode node1 = new ListNode(1);
    	ListNode node2 = new ListNode(2);
    	node1.next = node2;
    	removeNthFromEnd(node1, 1);
    }
}


