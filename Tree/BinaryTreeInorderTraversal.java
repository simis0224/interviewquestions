package Tree;


import java.util.ArrayList;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * For example:
 * Given binary tree {1,#,2,3},
 * 1
 *  \
 *    2
 *  /
 * 3
 * return [1,3,2].
 */
public class BinaryTreeInorderTraversal {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> result = new ArrayList<Integer>();
        inorder(root, result);
        return result;
    }
    
    public void inorder(TreeNode root, ArrayList<Integer> result) {
    	if(root == null) {
    		return;
    	}
    	
    	inorder(root.left, result);
    	result.add(root.val);
    	inorder(root.right, result);
    }
    
    
}
