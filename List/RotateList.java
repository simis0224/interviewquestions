package List;

/**
	Given a list, rotate the list to the right by k places, where k is non-negative.
	
	For example:
	Given 1->2->3->4->5->NULL and k = 2,
	return 4->5->1->2->3->NULL.
 */
public class RotateList {
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
    public static ListNode rotateRight(ListNode head, int n) {
        if(head == null) {
        	return null;
        }
        
        ListNode node1 = head;
        int nodeCount = 1;
    	while(node1.next != null) {
    		node1 = node1.next;
    		nodeCount++;
    	}
    	node1.next = head;
    	
    	ListNode node2 = node1;

    	// get the right nodeCount
    	int i = 1;
    	while(nodeCount <= n) {
    		nodeCount = nodeCount * i;
    		i++;
    	}
    	
    	// actually nodeCount - n = count - n%count
    	int steps = 0;
    	while(steps < nodeCount - n) {
    		node2 = node2.next;
    		steps++;
    	}
    	
    	head = node2.next;
    	node2.next = null;
    	
    	return head;
    }
    
    public static void main(String[] args) {
    	ListNode n1 = new ListNode(1);
    	ListNode n2 = new ListNode(2);
    	ListNode n3 = new ListNode(3);
    	n1.next = n2;
    	n2.next = n3;
    	rotateRight(n1, 4);
    }
}
