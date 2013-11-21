package needVerification;

import java.util.ArrayList;

public class FindLowestCommonAncestor {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	
	private static ArrayList<Integer> path1;
	private static ArrayList<Integer> path2;
	
	public static int findCommonAncestor(TreeNode root, int v1, int v2) {
		path1 = new ArrayList<Integer>();
		path2 = new ArrayList<Integer>();
		
		findPath(root, v1, v2, new ArrayList<Integer>());
		
		if(path1.size() > 0 && path2.size() > 0) {
			int preValue = path1.get(0);
			for(int i = 1; i < Math.min(path1.size(), path2.size()); i++) {
				if(path1.get(i) != path2.get(i)) {
					return preValue;
				} else {
					preValue = path1.get(i);
				}
			}
		}
		return -1;
	}
	
	public static void findPath(TreeNode node, int v1, int v2, ArrayList<Integer> path) {
		if(node == null) {
			return;
		}
		
		path.add(node.val);
		if(node.val == v1) {
			path1 = new ArrayList<Integer>(path);
		}
		
		if(node.val == v2) {
			path2 = new ArrayList<Integer>(path);
		}
		
		if(path1.size() > 0 && path2.size() > 0) {
			return;
		}
		
		int pathIndex = path.size() - 1;
		findPath(node.left, v1, v2, path);
		findPath(node.right, v1, v2, path);
		path.remove(pathIndex);
		
	}
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		TreeNode n9 = new TreeNode(9);
		TreeNode n10 = new TreeNode(10);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		n6.left = n8;
		n9.left = n9;
		n8.right = n10;
		
		findCommonAncestor(n1, 10, 7);
	}

}
