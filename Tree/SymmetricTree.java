package Tree;
import java.util.ArrayList;
import java.util.List;

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
 */
public class SymmetricTree {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public static class QueueItem {
		TreeNode node;
		int level;
		QueueItem(TreeNode node, int level) {
			this.node = node;
			this.level = level;
		}
	}
	 
	 
    public static boolean isSymmetric(TreeNode root) {
    	if(root == null) {
    		return true;
    	}
    	
    	int level = 1;
    	List<QueueItem> queue = new ArrayList<QueueItem>();
    	queue.add(new QueueItem(root, level));
    	while(!queue.isEmpty()) {
    		List<QueueItem> levelNodeList = new ArrayList<QueueItem>();
    		while(true) {
    			if(!queue.isEmpty() && queue.get(0).level == level) {
    				levelNodeList.add(queue.get(0));
    				if(queue.get(0).node.left != null) {
    					queue.add(new QueueItem(queue.get(0).node.left, level + 1));
    				} else if(queue.get(0).node.val != Integer.MIN_VALUE) {
    					queue.add(new QueueItem(new TreeNode(Integer.MIN_VALUE), level + 1));
    				}
    				if(queue.get(0).node.right != null) {
    					queue.add(new QueueItem(queue.get(0).node.right, level + 1));
    				} else if(queue.get(0).node.val != Integer.MIN_VALUE) {
    					queue.add(new QueueItem(new TreeNode(Integer.MIN_VALUE), level + 1));
    				}
    				queue.remove(0);
    			} else {
    				break;
    			}
    		}
    		
    		for(int i = 0, j = levelNodeList.size() - 1; i <= j; i++, j--) {
    			if(levelNodeList.get(i).node.val != levelNodeList.get(j).node.val) {
    				return false;
    			}
    		}
    		level++;
    	}
    	
    	return true;
    }
    //{3,67,67,18,#,#,18,-1,-64,-64,-1,#,61,-20,#,#,-20,#,61}
    public static void main(String [] args) {
    	isSymmetric(new TreeNode(1));
    }
}
