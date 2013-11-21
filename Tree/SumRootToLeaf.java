package Tree;
/**
	Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
	
	An example is the root-to-leaf path 1->2->3 which represents the number 123.
	
	Find the total sum of all root-to-leaf numbers.
	
	For example,
	
	    1
	   / \
	  2   3
	The root-to-leaf path 1->2 represents the number 12.
	The root-to-leaf path 1->3 represents the number 13.
	
	Return the sum = 12 + 13 = 25.
 */
public class SumRootToLeaf {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	int sum = 0;
	
    public int sumNumbers(TreeNode root) {
        sumNumbers(root, 0);
        int value = sum;
        sum = 0;
        return value;
    }
    
    
    public void sumNumbers(TreeNode node, int number) {
    	if(node == null) {
    		return;
    	}
    	
    	int value = number * 10 + node.val;
    	
        if(node.left == null && node.right == null) {
        	sum += value;
        }
        
        sumNumbers(node.left, value);
        sumNumbers(node.right, value);
    }
}
