package List;
/**
	Given a linked list, swap every two adjacent nodes and return its head.
	
	For example,
	Given 1->2->3->4, you should return the list as 2->1->4->3.
	
	Your algorithm should use only constant space. You may not modify the values 
	in the list, only nodes itself can be changed.
 */
public class SwapNodesInPair {
    public ListNode swapPairs(ListNode head) {
    	return swapPairs(head, null);
    }
    
    public ListNode swapPairs(ListNode head, ListNode lastNode) {
        if(head == null) {
        	return null;
        }
        
        ListNode secondNode = head.next;
        
        if(secondNode != null) {
        	ListNode tmp = swapPairs(secondNode.next, secondNode);
        	head.next = tmp;
        	secondNode.next = head;
        	if(lastNode != null) {
        		lastNode.next = secondNode;
        	}
        	return secondNode;
        } else {
        	return head;
        }
    }
    
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
