package needVerification;

import java.util.Stack;

public class MirrorTree {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public static TreeNode createMirrorTree(TreeNode node) {
		if(node == null) {
			return null;
		}
		
		TreeNode newNode = new TreeNode(node.val);
		newNode.left = createMirrorTree(node.right);
		newNode.right = createMirrorTree(node.left);
		
		return newNode;
	}
	
	public static TreeNode createMirrorTreeNonRecursive(TreeNode node) {
		if(node == null) {
			return null;
		}
		
		Stack<TreeNode> oldTreeStack = new Stack<TreeNode>();
		Stack<TreeNode> newTreeStack = new Stack<TreeNode>();
		
		TreeNode newRoot = new TreeNode(node.val);
		
		oldTreeStack.add(node);
		newTreeStack.add(newRoot);
		
		while(!oldTreeStack.isEmpty()) {
			TreeNode oldTreeNode = oldTreeStack.pop();
			TreeNode newTreeNode = newTreeStack.pop();
			
			TreeNode oldLeft = oldTreeNode.left;
			TreeNode oldRight = oldTreeNode.right;
			
			TreeNode newLeft = oldRight == null ? null : new TreeNode(oldRight.val);
			TreeNode newRight = oldLeft == null ? null : new TreeNode(oldLeft.val);
			
			newTreeNode.left = newLeft;
			newTreeNode.right = newRight;
			
			if(oldRight != null) {
				oldTreeStack.add(oldRight);
				newTreeStack.add(newLeft);
			}
			
			if(oldLeft != null) {
				oldTreeStack.add(oldLeft);
				newTreeStack.add(newRight);
			}
		}
		
		return newRoot;
	}
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		TreeNode n9 = new TreeNode(9);
		TreeNode n10 = new TreeNode(10);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		n6.left = n8;
		n8.left = n9;
		n8.right = n10;
		
		TreeNode node = createMirrorTreeNonRecursive(n1);
	}

}
