package Tree;
/**
	Given a binary tree, find the maximum path sum.
	
	The path may start and end at any node in the tree.
	
	For example:
	Given the below binary tree,
	
	       1
	      / \
	     2   3
	Return 6
**/
public class BinaryTreeMaxPathSum {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
    private static int max = Integer.MIN_VALUE;
    
    public static int maxPathSum(TreeNode root) {
    	max = Integer.MIN_VALUE;
    	getMaxPathSum(root);
    	return max;
    }
    
    public static int getMaxPathSum(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root.left == null && root.right == null) {
        	if(root.val > max) {
        		max = root.val;
        	}
        	return root.val;
        }
        
        Integer leftMax = root.left != null ? getMaxPathSum(root.left) : Integer.MIN_VALUE;
        Integer rightMax = root.right != null ? getMaxPathSum(root.right) : Integer.MIN_VALUE;
        
        int singlePathMax = Integer.MIN_VALUE;
        if(Math.max(leftMax, rightMax) < 0) {
        	singlePathMax = root.val;
        } else {
        	singlePathMax = Math.max(leftMax, rightMax) + root.val;
        }
        
        // pick the max from both single path of left and right path
        int newMax = singlePathMax;
        if(leftMax > 0 && rightMax > 0) {
        	newMax = Math.max(newMax, leftMax + rightMax + root.val);
        }
        
        if(newMax > max) {
        	max = newMax;
        }
        
        return singlePathMax;
    }
    
    public static void main(String [] args) {
    	TreeNode n1 = new TreeNode(0);
//    	TreeNode n2 = new TreeNode(2);
//    	TreeNode n3 = new TreeNode(3);
//    	n1.left = n2;
//    	n1.right = n3;
    	maxPathSum(n1);
    }
}
