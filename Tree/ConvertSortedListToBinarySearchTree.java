package Tree;

/**
	Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 */

public class ConvertSortedListToBinarySearchTree {
	
    public static class ListNode {
    	int val;
    	ListNode next;
    	ListNode(int x) {
    		val = x;
    		next = null;
    	}
    }
    
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	
    public static TreeNode sortedListToBST(ListNode head) {
        
    	int count = 0;
    	ListNode p = head;
    	while(p != null) {
    		p = p.next;
    		count++;
    	}
    	
    	return sortedListToBST(head, count);
    	
    }
    
    
    public static TreeNode sortedListToBST(ListNode list, int length) {
    	if(list == null || length == 0) {
    		return null;
    	}
    	
    	if(length == 1) {
    		return new TreeNode(list.val);
    	}
    	
    	TreeNode leftNode = sortedListToBST(list, length / 2);
    	TreeNode rightNode = null;
    	
    	list.val = list.next.val;
    	list.next = list.next.next;
    	TreeNode node = new TreeNode(list.val);
    	if(length - length / 2 - 1 > 0) {
	    	list.val = list.next.val;
	    	list.next = list.next.next;
	    	rightNode = sortedListToBST(list, length - length / 2 - 1);
    	}
    	node.left = leftNode;
    	node.right = rightNode;
    	return node;
    }
    
    public static void main(String[] args) {
    	ListNode n1 = new ListNode(-1);
    	ListNode n2 = new ListNode(0);
    	ListNode n3 = new ListNode(1);
    	ListNode n4 = new ListNode(2);
    	n1.next = n2;
    	n2.next = n3;
    	n3.next = n4;
    	
    	sortedListToBST(n1);
    }
}
