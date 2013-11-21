package Tree;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * @author qlu
 *
 */
public class ConvertSortedArrayToBST {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public TreeNode sortedArrayToBST(int[] num) {
		return convert(num, 0, num.length - 1);
	}
	
	public TreeNode convert(int[] num, int s1, int e1) {
		if(s1 > e1) {
			return null;
		}
		
		if(s1 == e1) {
			return new TreeNode(num[s1]);
		}
		
		int middle = (s1 + e1) / 2;
		TreeNode node = new TreeNode(num[middle]);
		node.left = convert(num, s1, middle - 1);
		node.right = convert(num, middle + 1, e1);
		return node;
	}

}
