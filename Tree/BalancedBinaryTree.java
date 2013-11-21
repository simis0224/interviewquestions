package Tree;

/**
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as 
 * a binary tree in which the depth of the two subtrees of every 
 * node never differ by more than 1.
 */
public class BalancedBinaryTree {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public static class Result {
		boolean isBalanced;
		int depth;
		Result(boolean isBalanced, int depth) {
			this.isBalanced = isBalanced;
			this.depth = depth;
		}
	}
	
	public boolean isBalanced(TreeNode root) {
		return getIsBalanced(root).isBalanced;
	}
	
	public Result getIsBalanced(TreeNode root) {
		if(root == null) {
			return new Result(true, 0);
		}
		
		if(root.left == null && root.right == null) {
			return new Result(true,  1);
		}
		
		Result leftResult = null;
		Result rightResult = null;
		leftResult = getIsBalanced(root.left);
		rightResult= getIsBalanced(root.right);
		
		return new Result (leftResult.isBalanced && rightResult.isBalanced
				&& (Math.abs(leftResult.depth - rightResult.depth) <= 1), 
				Math.max(leftResult.depth, rightResult.depth) + 1);
	}

}
