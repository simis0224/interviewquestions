package Tree;
/**
	Given a binary tree, find its minimum depth.
	
	The minimum depth is the number of nodes along
	the shortest path from the root node down to the nearest leaf node.
 */
public class MinDepthBinaryTree {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public int minDepth(TreeNode root) {
		return getMinDepth(root, 0);
	}
	
	public int getMinDepth(TreeNode root, int curDepth) {
		if(root == null) {
			return 0;
		}
		
		if(root.left == null && root.right == null) {
			return curDepth + 1;
		}
		
		int leftMin = Integer.MAX_VALUE;
		int rightMin = Integer.MAX_VALUE;
		if(root.left != null) {
			leftMin = getMinDepth(root.left, curDepth + 1);
		}
		if(root.right != null) {
			rightMin = getMinDepth(root.right, curDepth + 1);
		}
		
		return Math.min(leftMin, rightMin);
	}

}
