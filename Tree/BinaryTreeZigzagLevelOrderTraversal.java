package Tree;

import java.util.ArrayList;

/**
	Given a binary tree, return the zigzag level order traversal of its nodes' values. 
	(ie, from left to right, then right to left for the next level and alternate between).
	
	For example:
	Given binary tree {3,9,20,#,#,15,7},
	
	    3
	   / \
	  9  20
	    /  \
	   15   7
	return its zigzag level order traversal as:
	
	[
	  [3],
	  [20,9],
	  [15,7]
	]
 */
public class BinaryTreeZigzagLevelOrderTraversal {
	
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
	
	
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
    	
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        
        // null case
        if(root == null) {
        	return results;
        }
        
        
        ArrayList<Integer> result = null;
        ArrayList<NodeInfo> queue =  new ArrayList<NodeInfo>();
        
        queue.add(new NodeInfo(root, 0));
        int curLevel = -1;
        while(!queue.isEmpty()) {
        	NodeInfo node = queue.get(0);
        	queue.remove(0);
        	
        	if(curLevel != node.level) {
        		if(result != null) {
        			results.add(result);
        		}
        		curLevel = node.level;
        		result = new ArrayList<Integer>();
        	}
        	if(curLevel % 2 == 1) {
        		result.add(0, node.node.val);
        	} else {
        		result.add(node.node.val);
        	}
        	
        	if(node.node.left != null) {
        		queue.add(new NodeInfo(node.node.left, curLevel + 1));
        	}
        	
        	if(node.node.right != null) {
        		queue.add(new NodeInfo(node.node.right, curLevel + 1));
        	}
        }
        
        // don't forget the last result node
        if(result != null && result.size() > 0) {
        	results.add(result);
        }
        
        return results;
    }
}
