package List;

/**
	Given a linked list and a value x, partition it such that all nodes less than x come before 
	nodes greater than or equal to x.
	
	You should preserve the original relative order of the nodes in each of the two partitions.
	
	For example,
	Given 1->4->3->2->5->2 and x = 3,
	return 1->2->2->4->3->5.
 */
public class PartitionList {
	
    public static class ListNode {
    	int val;
    	ListNode next;
    	ListNode(int x) {
    		val = x;
    		next = null;
    	}
    }
	
    public static ListNode partition(ListNode head, int x) {
        if(head == null) {
        	return head;
        }
        
        ListNode lastNode = null;
        ListNode p = head;
        ListNode preP = null;
        while(p != null) {
        	if(p.val < x) {
        		// don't do any swap if preP  == lastNode
        		if(preP == null || preP == lastNode) {
        			preP = p;
        			lastNode = p;
        			p = p.next;
        		} else {
        			// use nextP
        			ListNode nextP = p.next;
        			preP.next = p.next;
        			if(lastNode == null) {
        				p.next = head;
        				head = p;
        			} else {
        				p.next = lastNode.next;
        				lastNode.next = p;
        			}
        			lastNode = p;
        			p = nextP;
        		}
        	} else {
        		preP = p;
        		p = p.next;
        	}
        }
        return head;
    }
    
    public static void main(String[] args) {
    	ListNode n1 = new ListNode(1);
    	ListNode n2 = new ListNode(2);
    	ListNode n3 = new ListNode(3);
    	n1.next = n2;
    	n2.next = n3;
    	partition(n1, 4);
    }
}
