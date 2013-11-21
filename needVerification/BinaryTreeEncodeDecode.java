package needVerification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class BinaryTreeEncodeDecode {
	
	public static class TreeNode {
		int val;
		TreeNode left = null;
		TreeNode right = null;
		
		public TreeNode() {}
		
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static String encode(TreeNode root) {
		if(root == null) {
			return "";
		}
		
		ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
		queue.add(root);
		String result = root.val + " ";
		while(!queue.isEmpty()) {
			TreeNode node = queue.remove(0);
			
			result = result + (node.left == null ? "# " : (node.left.val + " "));
			result = result + (node.right == null ? "# " : (node.right.val + " "));
			
			if(node.left != null) {
				queue.add(node.left);
			}
			
			if(node.right != null) {
				queue.add(node.right);
			}
		}
		
		return result;
	}
	
	public static TreeNode decode(String code) {
		if(code == null || code.length() == 0) {
			return null;
		}
		
		String[] nodes = code.split(" ");
		
		ArrayList<ArrayList<TreeNode>> tree = new ArrayList<ArrayList<TreeNode>>();
		ArrayList<TreeNode> level = new ArrayList<TreeNode>();
		level.add(new TreeNode(Integer.valueOf(nodes[0])));
		tree.add(level);
		
		int i = 1;
		int curLevel = 0;
		int curIndex = 0;
		level = new ArrayList<TreeNode>();
		while(i < nodes.length) {
			TreeNode left = nodes[i].equals("#") ? null : new TreeNode(Integer.valueOf(nodes[i]));
			TreeNode right = nodes[i + 1].equals("#") ? null : new TreeNode(Integer.valueOf(nodes[i + 1]));
			i = i + 2;

			if(curIndex == tree.get(curLevel).size()) {
				tree.add(level);
				level = new ArrayList<TreeNode>();
				curIndex = 0;
				curLevel++;
			}			
			
			tree.get(curLevel).get(curIndex).left = left;
			tree.get(curLevel).get(curIndex).right = right;
			if(left != null) {
				level.add(left);
			}
			if(right != null) {
				level.add(right);
			}
			curIndex ++;
		}
		return tree.get(0).get(0);
		
	}
	
	private static String encodeResult = "";
	public static String encodePreOrder(TreeNode node) {
		encodeResult = "";
		doEncodePreOrder(node);
		return encodeResult;
	}
	
	public static void doEncodePreOrder(TreeNode node) {
		if(node == null) {
			encodeResult += "# ";
			return;
		}
		
		encodeResult += node.val + " ";
		doEncodePreOrder(node.left);
		doEncodePreOrder(node.right);
	}
	
	public static TreeNode decodePreOrder(String code) {
		if(code == null || code.trim().length() == 0) {
			return null;
		}
		
		String[] tokens = code.split(" ");
		List<String> tokenList = Arrays.asList(tokens);
		return doDecodePreOrder(tokenList.iterator());
	}
	
	public static TreeNode doDecodePreOrder(Iterator<String> i) {
		if(!i.hasNext()) {
			return null;
		}
		
		String val = i.next();
		TreeNode node = null;
		if(!val.equals("#")) {
			node = new TreeNode(Integer.valueOf(val));
			node.left = doDecodePreOrder(i);
			node.right = doDecodePreOrder(i);
		}
		return node;
	}
	
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		n1.left = n2;
		n1.right = n3;
		n3.left = n4;
		n4.right = n5;
	//	encodePreOrder(n1);
		TreeNode root = decodePreOrder("1 2 # # 3 4 # 5 # # #");
		//encode(n1);
		//decode("1 2 3 # # 4 # # 5 # #"); 
	}

}
