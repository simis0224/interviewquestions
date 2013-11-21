package Tree;
/**
	Given a binary tree, find its maximum depth.

	The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */

public class MaxDepthBinaryTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public int maxDepth(TreeNode root) {
		return getMaxDepth(root, 0);
	}
	
	public int getMaxDepth(TreeNode root, int curDepth) {
		if(root == null) {
			return 0;
		}
		
		if(root.left == null && root.right == null) {
			return curDepth + 1;
		}
		
		int leftMax = Integer.MIN_VALUE;
		int rightMax = Integer.MIN_VALUE;
		if(root.left != null) {
			leftMax = getMaxDepth(root.left, curDepth + 1);
		}
		if(root.right != null) {
			rightMax = getMaxDepth(root.right, curDepth + 1);
		}
		
		return Math.max(leftMax, rightMax);
	}
}
