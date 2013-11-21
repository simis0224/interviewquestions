package Tree;

import java.util.ArrayList;

/**
	Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
	
	For example,
	Given n = 3, your program should return all 5 unique BST's shown below.
	
	   1         3     3      2      1
	    \       /     /      / \      \
	     3     2     1      1   3      2
	    /     /       \                 \
	   2     1         2                 3
 */

public class UniqueBinarySearchTreeII {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
    public static ArrayList<TreeNode> generateTrees(int n) {
    	ArrayList<Integer> elements = new ArrayList<Integer>();
        for(int i = 1; i <= n; i++) {
        	elements.add(i);
        }
        
        return generateTrees(elements);
    }
    
    public static ArrayList<TreeNode> generateTrees(ArrayList<Integer> elements) {
    	ArrayList<TreeNode> results = new ArrayList<TreeNode>();
    	if(elements.size() == 0) {
    		results.add(null);
    	} else if(elements.size() == 1) {
    		results.add(new TreeNode(elements.get(0)));
    	} else {
    		ArrayList<Integer> leftElements = new ArrayList<Integer>();
    		ArrayList<Integer> rightElements = new ArrayList<Integer>(elements);
    		rightElements.remove(0);
	    	for(int i = 0; i < elements.size(); i++) {
	    		
	    		ArrayList<TreeNode> leftResult = generateTrees(leftElements);
	    		ArrayList<TreeNode> rightResult = generateTrees(rightElements);
	    		
	    		for(int j = 0; j < leftResult.size(); j++) {
	    			for(int k = 0; k < rightResult.size(); k++) {
	    				TreeNode node = new TreeNode(elements.get(i));
	    				node.left = leftResult.get(j);
	    				node.right = rightResult.get(k);
	    				results.add(node);
	    			}
	    		}
	    		leftElements.add(elements.get(i));
	    		if(!rightElements.isEmpty()) {
	    			rightElements.remove(0);
	    		}
	    	}
    	}
    	
    	return results;
    }
    
    public static void main(String[] args) {
    	generateTrees(2);
    }
	
}
