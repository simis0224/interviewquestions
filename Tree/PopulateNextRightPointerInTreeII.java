package Tree;
/**
	Follow up for problem "Populating Next Right Pointers in Each Node".
	
	What if the given tree could be any binary tree? Would your previous solution still work?
	
	Note:
	
	You may only use constant extra space.
	For example,
	Given the following binary tree,
	
	         1
	       /  \
	      2    3
	     / \    \
	    4   5    7
	After calling your function, the tree should look like:
	
	         1 -> NULL
	       /  \
	      2 -> 3 -> NULL
	     / \    \
	    4-> 5 -> 7 -> NULL
 */
public class PopulateNextRightPointerInTreeII {
	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x) { val = x; }
	}
	
    public void connect(TreeLinkNode root) {
        TreeLinkNode parentNode = root;
        
        while(parentNode != null) {
        	TreeLinkNode node = parentNode;
        	TreeLinkNode childNode = null;
        	TreeLinkNode nextLevelFirstNode = null;
        	while(node != null) {
        		if(childNode == null) {
        			if(node.left != null || node.right != null) {
        				childNode = node.left != null ? node.left : node.right;
        				nextLevelFirstNode = childNode;
        				if(node.left != null && node.right != null) {
        					childNode.next = node.right;
        					childNode = childNode.next;
        				}
        			}
        		} else {
        			if(node.left != null) {
        				childNode.next = node.left;
        				childNode = childNode.next;
        			} 
        			if(node.right != null) {
        				childNode.next = node.right;
        				childNode = childNode.next;
        			}
        		}
            	node = node.next;
        	}
        	parentNode = nextLevelFirstNode;
        }
    }
}
