package Tree;

/**
	Given preorder and inorder traversal of a tree, construct the binary tree.
	
	Note:
	You may assume that duplicates do not exist in the tree.
**/
public class ConstructBinaryTreePreorderInorder {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    public TreeNode buildTree(int[] preorder, int s1, int e1, int[] inorder, int s2, int e2) {
    	if(s1 > e1 || s2 > e2) {
    		return null;
    	}
    	
    	int i = s2;
    	for(; i <= e2; i++) {
    		if(inorder[i] == preorder[s1]) {
    			break;
    		}
    	}
    	
    	TreeNode node = new TreeNode(preorder[s1]);
    	node.left = buildTree(preorder, s1 + 1, i - s2 + s1, inorder, s2, i - 1);
    	node.right = buildTree(preorder, i - s2 + s1 + 1, e1, inorder, i + 1, e2);
    	return node;
    }
}
