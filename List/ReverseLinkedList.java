package List;

import List.ReverseLinkedListII.ListNode;

public class ReverseLinkedList {
	
    public static class ListNode {
    	int val;
    	ListNode next;
    	ListNode(int x) {
    		val = x;
    		next = null;
    	}
    }
    
    public static ListNode reverseLinkedList(ListNode head) {
    	if(head == null || head.next == null) {
    		return head;
    	}
    	
    	ListNode pre = head;
    	ListNode p = head.next;
    	while(p != null) {
    		pre.next = p.next;
    		p.next = head;
    		head = p;
    		p = pre.next;
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
    	reverseLinkedList(n1);
    }
}
