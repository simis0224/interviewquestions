package List;
import java.util.ArrayList;

/**
	Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */
public class MergeKSortedList {
    public static ListNode mergeKLists(ArrayList<ListNode> lists) {
    	if(lists.size() == 0) {
    		return null;
    	}
    	
    	if(lists.size() == 1) {
    		return lists.get(0);
    	}
    	
    	ArrayList<ListNode> lists1 = new ArrayList<ListNode>();
    	ArrayList<ListNode> lists2 = new ArrayList<ListNode>();
    	
    	for(int i = 0; i < lists.size() / 2; i++) {
    		lists1.add(lists.get(i));
    	}
    	
    	for(int i = lists.size() / 2 ; i < lists.size(); i++) {
    		lists2.add(lists.get(i));
    	}
    	
    	ListNode list1 = mergeKLists(lists1);
    	ListNode list2 = mergeKLists(lists2);
    	
    	ListNode head = null;
    	ListNode node = null;
    	ListNode lastNode = null;
    	
    	while(list1 != null && list2 != null) {
    		int value = list1.val < list2.val ? list1.val : list2.val;
    		node = new ListNode(value);
    		if(head == null) {
    			head = node;
    		} else {
    			lastNode.next = node;
    			
    		}
    		lastNode = node;
    		if(list1.val < list2.val) {
    			list1 = list1.next;
    		} else {
    			list2 = list2.next;
    		}
    	}
    	
		if(list1 != null) {
			if(head == null) {
				head = list1;
			} else {
				lastNode.next = list1;
			}
		}
		
		if(list2 != null) {
			if(head == null) {
				head = list2;
			} else {
				lastNode.next = list2;
			}
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
    	ArrayList<ListNode> a = new ArrayList<ListNode>();
    	ListNode a1 = new ListNode(1);
    	ListNode a2 = new ListNode(1);
    	ListNode a3 = new ListNode(2);
    	a1.next = a2;
    	a2.next = a3;
    	
    	ListNode b1 = new ListNode(1);
    	ListNode b2 = new ListNode(2);
    	ListNode b3 = new ListNode(2);
    	b1.next = b2;
    	b2.next = b3;
    	
    	a.add(a1);
    	a.add(b1);
    	mergeKLists(a);
    }

}
