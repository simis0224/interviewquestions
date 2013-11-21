package Tree;

import java.util.ArrayList;

/**
	Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
	
	For example:
	Given the below binary tree and sum = 22,
	              5
	             / \
	            4   8
	           /   / \
	          11  13  4
	         /  \    / \
	        7    2  5   1
	return
	
	[
	   [5,4,11,2],
	   [5,8,4,5]
	]
 */

public class PathSumII {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	ArrayList<ArrayList<Integer>> results;
	
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        results = new ArrayList<ArrayList<Integer>>();
        doDFS(root, new ArrayList<Integer>(), 0, sum);
        return results;
    }
    
    public void doDFS(TreeNode root, ArrayList<Integer> path, int curSum, int target) {
    	if(root == null) {
    		return;
    	}
    	
    	path.add(root.val);
    	
    	if(root.left == null && root.right == null) {
    		if(curSum + root.val == target) {
    			results.add(new ArrayList<Integer>(path));
    			// be sure to remove cur node before the method return
    			path.remove(path.size() - 1);
    			return;
    		}
    	}
    	
    	doDFS(root.left, path, curSum + root.val, target);
    	doDFS(root.right, path, curSum + root.val, target);
    	path.remove(path.size() - 1);
    }
}
