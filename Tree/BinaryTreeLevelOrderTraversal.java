package Tree;


import java.util.ArrayList;
/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

	For example:
	Given binary tree {3,9,20,#,#,15,7},
	
	    3
	   / \
	  9  20
	    /  \
	   15   7
	return its level order traversal as:
	
	[
	  [3],
	  [9,20],
	  [15,7]
	]
 */
public class BinaryTreeLevelOrderTraversal {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public static class LevelInfo {
		int level;
		TreeNode node;
		LevelInfo(TreeNode node, int level) {
			this.node = node;
			this.level = level;
		}
	}
	
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		// dont' fotget null case
		if(root == null) {
			return results;
		}
		
		ArrayList<LevelInfo> queue = new ArrayList<LevelInfo>();
		queue.add(new LevelInfo(root, 1));
		while(!queue.isEmpty()) {
			int level = queue.get(0).level;
			ArrayList<Integer> list = new ArrayList<Integer>();
			while(!queue.isEmpty() && level == queue.get(0).level) {
				LevelInfo levelInfo = queue.get(0);
				queue.remove(0);
				list.add(levelInfo.node.val);
				if(levelInfo.node.left != null) {
					queue.add(new LevelInfo(levelInfo.node.left, levelInfo.level + 1));
				}
				if(levelInfo.node.right != null) {
					queue.add(new LevelInfo(levelInfo.node.right, levelInfo.level + 1));
				}
			}
			results.add(list);
		}
		return results;
	}
}
