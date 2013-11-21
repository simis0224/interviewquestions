package Tree;
/**
	Given two binary trees, write a function to check if they are equal or not.
	
	Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 */

public class SameTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public boolean isSameTree(TreeNode root) {
		if(root == null) {
			return true;
		}
		
		return isSameTree(root.left, root.right);
	}
	
	public boolean isSameTree(TreeNode node1, TreeNode node2) {
		if(node1 == null && node2 == null) {
			return true;
		}
		
		if((node1 == null && node2 != null) || (node1 != null && node2 == null)) {
			return false;
		}
		
		if(node1.val != node2.val) {
			return false;
		}
		
		return isSameTree(node1.left, node2.left) && isSameTree(node1.right, node2.right);
	}
}
