package Tree;
/**
	Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
	
	For example, this binary tree is symmetric:
	
	    1
	   / \
	  2   2
	 / \ / \
	3  4 4  3
	But the following is not:
	
	    1
	   / \
	  2   2
	   \   \
	   3    3
	Note:
	Bonus points if you could solve it both recursively and iteratively.
**/

public class SymmetricTreeRecursive {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public boolean isSymmetric(TreeNode root) {
		if(root == null) {
			return true;
		}
		
		return isSymmetric(root.left, root.right);
	}
	
	public boolean isSymmetric(TreeNode node1, TreeNode node2) {
		if(node1 == null && node2 == null) {
			return true;
		}
		
		if((node1 == null && node2 != null) || (node1 != null && node2 == null)) {
			return false;
		}
		
		if(node1.val != node2.val) {
			return false;
		}
		
		return isSymmetric(node1.left, node2.right) && isSymmetric(node1.right, node2.left);
	}
}
