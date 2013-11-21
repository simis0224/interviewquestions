package List;

/**
	Reverse a linked list from position m to n. Do it in-place and in one-pass.
	
	For example:
	Given 1->2->3->4->5->NULL, m = 2 and n = 4,
	
	return 1->4->3->2->5->NULL.
	
	Note:
	Given m, n satisfy the following condition:
	1 ? m ? n ? length of list.
 */
public class ReverseLinkedListII {
	
	
    public static class ListNode {
    	int val;
    	ListNode next;
    	ListNode(int x) {
    		val = x;
    		next = null;
    	}
    }
	
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        
    	// null check
    	if(head == null) {
        	return head;
        }
    	
    	ListNode p = head;
    	ListNode pre = null;
    	int count = m;
    	while(p != null && count > 1) {
    		pre = p;
    		p = p.next;
    		count--;
    	}
    	
    	// m > list length
    	if(p == null && count > 1) {
    		return head;
    	}
    	
    	ListNode k = pre;
    	ListNode groupHead = p;
    	pre = p;
    	p = p.next;
    	count = n - m;
    	while(p != null && count > 0) {
    		pre.next = p.next;
    		p.next = groupHead;
    		groupHead = p;
    		p = pre.next;
    		count--;
    	}
    	
    	if(k != null) {
    		k.next = groupHead;
    	} else {
    		head = groupHead;
    	}
    	
    	return head;
    }
    
    public static void main(String[] args) {
    	ListNode n1 = new ListNode(1);
    	ListNode n2 = new ListNode(2);
    	ListNode n3 = new ListNode(3);
    	n1.next = n2;
    	n2.next = n3;
    	reverseBetween(n1, 2, 3);
    }
}
