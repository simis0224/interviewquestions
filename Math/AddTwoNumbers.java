package Math;

/**
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) {
	 *         val = x;
	 *         next = null;
	 *     }
	 * }
	 */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return addTwoNumbers(l1, l2, 0);
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
    	if(l1 == null && l2 == null) {
    		return carry > 0 ? new ListNode(carry) : null;
    	}
    	
    	int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
    	int value = sum % 10;
    	int nextCarry = sum >= 10 ? 1 : 0;
    	ListNode newNode = new ListNode(value);
    	newNode.next = addTwoNumbers( (l1 == null ? null : l1.next), 
    			(l2 == null ? null : l2.next), nextCarry);
    	return newNode;
    }
    
    public int getCarry(int value, int curCarry) {
    	if(value + curCarry >= 10) {
    		return 1;
    	} else {
    		return 0;
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
