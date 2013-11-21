package Tree;
/**
	Given inorder and postorder traversal of a tree, construct the binary tree.
	
	Note:
	You may assume that duplicates do not exist in the tree.
**/

public class ConstructBinaryTreeInorderPostorder {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    public static TreeNode buildTree(int[] inorder, int s1, int e1, int[] postorder, int s2, int e2) {
    	if(s1 > e1 || s2 > e2) {
    		return null;
    	}
    	
    	int i = s1;
    	for(; i <= e1; i++) {
    		if(inorder[i] == postorder[e2]) {
    			break;
    		}
    	}
    	
    	TreeNode node = new TreeNode(postorder[e2]);
    	// special note
    	node.left = buildTree(inorder, s1, i - 1, postorder, s2, s2 + (i - 1 - s1));
    	node.right = buildTree(inorder, i + 1, e1, postorder, s2 + (i - s1), e2 - 1);
    	return node;
    }
    
    public static void main(String [] args) {
    	buildTree(new int[]{1, 3, 2}, new int[]{3, 2, 1});
    }
}
