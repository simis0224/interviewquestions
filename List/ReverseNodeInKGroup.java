package List;

/**
	Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
	
	If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
	
	You may not alter the values in the nodes, only nodes itself may be changed.
	
	Only constant memory is allowed.
	
	For example,
	Given this linked list: 1->2->3->4->5
	
	For k = 2, you should return: 2->1->4->3->5
	
	For k = 3, you should return: 3->2->1->4->5
 */

public class ReverseNodeInKGroup {
	
    public static class ListNode {
    	int val;
    	ListNode next;
    	ListNode(int x) {
    		val = x;
    		next = null;
    	}
    }
	
	
    public static ListNode reverseKGroup(ListNode head, int k) {
    	if(head == null || k == 1) {
    		return head;
    	}
    	
        ListNode p = head;
        ListNode pre = null;
        while(p != null) {
        	int count = 1;
        	ListNode tmp = p;
        	while(count != k && tmp != null) {
        		count++;
        		tmp = tmp.next;
        	}
        	
        	
        	if(tmp != null) {
        		ListNode groupHead = p;
        		ListNode groupPre = p;
        		ListNode groupNode = p.next;
        		count = k;
        		// swap count - 1 times
        	    while(count - 1 > 0) {
        	    	groupPre.next = groupNode.next;
        	    	groupNode.next = groupHead;
        	    	groupHead = groupNode;
        	    	groupNode = groupPre.next;
        	    	count--;
        	    }
        		if(pre != null) {
        			pre.next = groupHead;
        		} else {
        			head = groupHead;
        		}
        		pre = p;
        		p = groupPre.next;
        	} else {
        		break;
        	}
        }
        return head;
    }
    
    public static void main(String[] args) {
    	ListNode n1 = new ListNode(1);
    	ListNode n2 = new ListNode(2);
    	ListNode n3 = new ListNode(3);
    	ListNode n4 = new ListNode(4);
    	n1.next = n2;
    	n2.next = n3;
    	n3.next = n4;
    	reverseKGroup(n1, 4);
    }
}
