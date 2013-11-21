package needVerification;

public class MergeSortList {
	
    public static class ListNode {
    	int val;
    	ListNode next;
    	ListNode(int x) {
    		val = x;
    		next = null;
    	}
    }
    
    public static ListNode mergeSortList(ListNode node) {
    	if(node == null || node.next == null) {
    		return node;
    	}
    	
    	int length = 0;
    	ListNode n = node;
    	while(n != null) {
    		n = n.next;
    		length++;
    	}
    	
    	return mergeSortList(node, length);
    }
    
    public static ListNode mergeSortList(ListNode node, int length) {
    	if(node == null || length <= 1) {
    		if(node != null) {
    			// don't forget to set individual node's next to null
    			node.next = null;
    		}
    		return node;
    	}
    	
    	ListNode midNode = node;
    	int i = 0;
    	while(i < length / 2) {
    		midNode = midNode.next;
    		i++;
    	}
    	
    	ListNode n1 = mergeSortList(node, length / 2);
    	ListNode n2 = mergeSortList(midNode, length - length / 2);
    	
    	return mergeList(n1,  n2);
    }
    
    public static ListNode mergeList(ListNode n1, ListNode n2) {
    	ListNode head = null;
    	ListNode preNode = null;
    	while(n1 != null && n2 != null) {
    		ListNode newNode = null;
    		if(n1.val < n2.val) {
    			newNode = n1;
    			n1 = n1.next;
    		} else {
    			newNode = n2;
    			n2 = n2.next;
    		}
    		
    		if(head == null) {
    			head = newNode;
    		}
    		if(preNode != null) {
    			preNode.next = newNode;
    		}
    		preNode = newNode;
    	}
    	
        
        if(n1 != null) {
        	preNode.next = n1;
        }
        
        if(n2 != null) {
        	preNode.next = n2;
        }
        
        return head;
    }

    public static void main(String[] args) {
    	ListNode n1 = new ListNode(1);
    	ListNode n2 = new ListNode(3);
    	ListNode n3 = new ListNode(9);
    	ListNode n4 = new ListNode(2);
    	ListNode n5 = new ListNode(4);
    	ListNode n6 = new ListNode(5);
    	ListNode n7 = new ListNode(0);
    	ListNode n8 = new ListNode(8);
    	ListNode n9 = new ListNode(9);
    	ListNode n10 = new ListNode(7);
    	ListNode n11 = new ListNode(6);
    	n1.next = n2;
    	n2.next = n3;
    	n3.next = n4;
    	n4.next = n5;
    	n5.next = n6;
    	n6.next = n7;
    	n7.next = n8;
    	n8.next = n9;
    	n9.next = n10;
    	n10.next = n11;
    	ListNode n = mergeSortList(n1);
    }

}
