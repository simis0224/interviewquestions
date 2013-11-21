package Tree;

/**
	Two elements of a binary search tree (BST) are swapped by mistake.
	
	Recover the tree without changing its structure.
	
	Note:
	A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 */

public class RecoverBinarySearchTree {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	static TreeNode first = null;
	static TreeNode second = null;
	static TreeNode pre = null;
	
    public static void recoverTree(TreeNode root) {
    	first = null;
    	second = null;
    	pre = null;
        inorder(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
    
    public static void inorder(TreeNode root) {
    	if(root == null) {
    		return;
    	}
    	
    	// go to left child, pre remains the same until it reaches leaf node
    	inorder(root.left);
    	
    	if(pre != null && pre.val > root.val) {
    		if(first == null) {
    			/**
    			 * pre and root could be swapped
    			 */
    			first = pre;
    			second = root;
    		} else {
    			second = root;
    		}
    	}
    	pre = root;
    	inorder(root.right);
    }
    
    public static void main(String [] args) {
    	TreeNode n1 = new TreeNode(2);
    	TreeNode n2 = new TreeNode(1);
    	TreeNode n3 = new TreeNode(3);
    	n1.left = n2;
    	n2.right =n3;
    	recoverTree(n1);
    }
   
}
