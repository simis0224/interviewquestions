package Tree;

/**
	Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
	
	For example,
	Given n = 3, there are a total of 5 unique BST's.
	
	   1         3     3      2      1
	    \       /     /      / \      \
	     3     2     1      1   3      2
	    /     /       \                 \
	   2     1         2                 3
 */
public class UniqueBinarySearchTree {

	public static int numTrees(int n) {
		
		int[] numTrees = new int[n];
		numTrees[0] = 1;
		
		for(int i = 1; i < n; i++) {
			int sum = 0;
			for(int j = 0; j <= i; j++) {
				if(j == 0 || j == i) {
					sum += numTrees[i - 1];
				} else {
					//!!! j - 1 and i - j - 1
					sum += numTrees[j - 1] * numTrees[i - j - 1];
				}
			}
			numTrees[i] = sum;
		}
		return numTrees[n-1];
	}
	
	
//	public static int numTrees(int n) {
//		if(n <= 1) {
//			return n;
//		}
//		
//		int sum = 0;
//		for(int i = 1; i <= n; i++) {
//			if(i == 1 || i == n) {
//				sum += numTrees(n - 1);
//			}
//			sum += numTrees(i - 1) * numTrees(n - i);
//		}
//		return sum;
//	}
	
	public static void main(String [] args) {
		numTrees(3);
	}
	
}
