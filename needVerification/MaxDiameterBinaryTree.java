package needVerification;

import Tree.BalancedBinaryTree.TreeNode;

public class MaxDiameterBinaryTree {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public static class Result {
		int depth;
		int diameter;
		public Result(int depth, int diameter) {
			this.depth = depth;
			this.diameter = diameter;
		}
	}
	
	public static Result findMaxDiameter(TreeNode node) {
		if(node == null) {
			return new Result(0, 0);
		}
		
		Result left = findMaxDiameter(node.left);
		Result right = findMaxDiameter(node.right);
		
		return new Result(Math.max(left.depth, right.depth) + 1, left.depth + right.depth + 1);
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
		TreeNode n11 = new TreeNode(11);
		TreeNode n12 = new TreeNode(12);
		TreeNode n13 = new TreeNode(13);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n5.left = n6;
		n5.right = n7;
		n3.right = n8;
		n8.right = n9;
		n9.left = n10;
		n10.left = n11;
		n10.right = n12;
		n9.right = n13;
		Result result = findMaxDiameter(n1);
	}

}
