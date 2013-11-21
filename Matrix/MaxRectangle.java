package Matrix;

import java.util.Stack;

/**
 * 
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
 *
 */
public class MaxRectangle {
	
	public static class RectangleInfo {
		int height;
		int width;
		public RectangleInfo(int height, int position) {
			this.height = height;
			this.width = position;
		}
	}
    public static int maximalRectangle(char[][] matrix) {
    	if(matrix.length == 0) {
    		return 0;
    	}
    	
    	int max = 0;
    	for(int i = 0; i < matrix.length; i++) {
    		int[] histogram = new int[matrix[0].length];
    		for(int k = 0; k < matrix[0].length; k++) {
    			histogram[k] = matrix[i][k] == '0' ? 0 : histogram[k] + 1;
    			max = Math.max(max, maxRectangleFromHistogram(histogram));
    		}
    	}
        return max;
    }
    
    public static int maxRectangleFromHistogram(int[] histogram) {
    	if(histogram.length == 0) {
    		return 0;
    	}
    	int max = 0;
    	Stack<RectangleInfo> heightStack = new Stack<RectangleInfo>();
    	for(int i = 0; i <= histogram.length; i++) {
    		int newHeight = i == histogram.length ? 0 : histogram[i];
    		if(heightStack.isEmpty() || newHeight >= histogram[i-1]) {
    			heightStack.add(new RectangleInfo(newHeight, 1));
    		} else {
    			int width = 0;
    			while(!heightStack.isEmpty() && heightStack.peek().height >= newHeight) {
    				RectangleInfo info = heightStack.pop();
    				width += info.width;
    				max = Math.max(max, info.height * width);
    			}
    			heightStack.add(new RectangleInfo(newHeight, width + 1));
    		}
    	}
    	
    	return max;
    }
    
    public static void main(String[] args) {
    	maximalRectangle(new char[][]{{'1'}});
    	//maximalRectangle(new char[][]{{'0','1','1','0','1'},{'1','1','0','1','0'},{'0','1','1','1','0'},{'1','1','1','1','0'},{'1','1','1','1','1'},{'0','0','0','0','0'}});
    }
}
