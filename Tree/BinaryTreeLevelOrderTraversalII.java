package Tree;

import java.util.ArrayList;

/**
	Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
	(ie, from left to right, level by level from leaf to root).
	
	For example:
	Given binary tree {3,9,20,#,#,15,7},
	
	    3
	   / \
	  9  20
	    /  \
	   15   7
	return its bottom-up level order traversal as:
	
	[
	  [15,7]
	  [9,20],
	  [3],
	]
 */
public class BinaryTreeLevelOrderTraversalII {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public static class NodeInfo {
		TreeNode node;
		int level;
		NodeInfo(TreeNode node, int level) {
			this.node = node;
			this.level = level;
		}
	}
	
    public static ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
    	ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
    	// null case
    	if(root == null) {
    		return results;
    	}
    	
    	ArrayList<NodeInfo> queue = new ArrayList<NodeInfo>();
    	ArrayList<Integer> result = null;
    	queue.add(new NodeInfo(root, 0));
    	int curLevel = -1;
    	while(!queue.isEmpty()) {
    		NodeInfo node = queue.get(0);
    		queue.remove(0);
    		if(curLevel != node.level) {
    			if(result != null) {
    				results.add(0, result);
    			}
    			curLevel = node.level;
    			result = new ArrayList<Integer>();
    		} 
    		result.add(node.node.val);
    		
    		if(node.node.left != null) {
    			queue.add(new NodeInfo(node.node.left, node.level + 1));
    		}
    		
    		if(node.node.right != null) {
    			queue.add(new NodeInfo(node.node.right, node.level + 1));
    		}
    	}
    	
    	// don't forget the last one, also add to the beginning
    	if(result !=null && result.size() > 0) {
    		results.add(0, result);
    	}
    	
    	return results;
    }
    
    public static void main(String[] args) {
    	levelOrderBottom(new TreeNode(1));
    }
}
