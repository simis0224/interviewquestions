package Tree;
/**
	Given a binary tree, flatten it to a linked list in-place.
	
	For example,
	Given
	
	         1
	        / \
	       2   5
	      / \   \
	     3   4   6
	     
	The flattened tree should look like:
	
	   1
	    \
	     2
	      \
	       3
	        \
	         4
	          \
	           5
	            \
	             6
 */

import java.util.Stack;

public class FlatenBinaryTreeToLinkedList {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
    public void flatten(TreeNode root) {
    	if(root == null) {
    		return;
    	}
    	
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);
        TreeNode lastNode = null;
        while(!stack.isEmpty()) {
        	TreeNode node = stack.pop();
        	if(node.right != null) {
        		stack.add(node.right);
        	}
        	if(node.left != null) {
        		stack.add(node.left);
        	}
        	if(lastNode == null) {
        		lastNode = node;
        	} else {
        		lastNode.left = null;
        		lastNode.right = node;
        		lastNode = node;
        	}
        }
    }
}
