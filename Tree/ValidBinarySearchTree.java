package Tree;

/**
	Given a binary tree, determine if it is a valid binary search tree (BST).
	
	Assume a BST is defined as follows:
	
	The left subtree of a node contains only nodes with keys less than the node's key.
	The right subtree of a node contains only nodes with keys greater than the node's key.
	Both the left and right subtrees must also be binary search trees.
 */

public class ValidBinarySearchTree {
	
	 public class TreeNode {
	     int val;
	     TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	 }
	 
	 public class Result {
		 Integer maxNodeValue;
		 Integer minNodeValue;
		 boolean isBST;
		 Result(Integer maxNodeValue, Integer minNodeValue, boolean isBST) {
			 this.maxNodeValue = maxNodeValue;
			 this.minNodeValue = minNodeValue;
			 this.isBST = isBST;
		 }
	 }
	 
	 public boolean isValidBST(TreeNode root) {
		 return getIsValidBST(root).isBST;
	 }
	 
	
	// we can also in order traverse the tree
    public Result getIsValidBST(TreeNode root) {
    	if(root == null) {
    		return new Result(Integer.MIN_VALUE, Integer.MAX_VALUE, true);
    	}
    	
    	Result lResult = null;
    	Result rResult = null;
    	lResult = getIsValidBST(root.left);
    	rResult = getIsValidBST(root.right);
    	
    	boolean isBST = false;
    	int maxNodeValue = root.val;
    	int minNodeValue = root.val;
    	
		if(lResult.maxNodeValue < root.val && rResult.minNodeValue > root.val) {
			isBST = true;
		}
		
    	maxNodeValue = Math.max(root.val, lResult.maxNodeValue);
    	minNodeValue = Math.min(root.val, lResult.minNodeValue);
    	maxNodeValue = Math.max(maxNodeValue, rResult.maxNodeValue);
    	minNodeValue = Math.min(minNodeValue, rResult.minNodeValue);
    	
    	return new Result(maxNodeValue, minNodeValue, isBST && lResult.isBST && rResult.isBST);
    }
}
