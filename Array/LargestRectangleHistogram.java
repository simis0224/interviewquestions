package Array;
import java.util.Stack;
/**
	Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
	
	Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
	
	The largest rectangle is shown in the shaded area, which has area = 10 unit.
	
	For example,
	Given height = [2,1,5,6,2,3],
	return 10.
**/

public class LargestRectangleHistogram {
    public static int largestRectangleArea(int[] height) {
    	
    	Stack<Integer> heightStack = new Stack<Integer>();
    	Stack<Integer> widthStack = new Stack<Integer>();
    	int maxArea = 0;
    	
    	for(int i = 0; i <= height.length; i++) {
    		int newHeight = i < height.length ? height[i] : 0;
    		// if 1) heightStack is empty or 2) newHeight > heightStack's top, add newHeight to the top
    		if(heightStack.isEmpty() || heightStack.peek() <= newHeight) {
    			heightStack.add(newHeight);
    			widthStack.add(1);
    		} else {
    			// else pop the stack until the top of heightStack is not bigger than newHeight
    			// then calculate the area using all the height pop out
    			// add newHeight and the sum of width to the stack
				int minHeight = Integer.MAX_VALUE;
				int width = 0;
				while(!heightStack.isEmpty() && heightStack.peek() > newHeight) {
					minHeight = Math.min(minHeight, heightStack.pop());
					width += widthStack.pop();
					maxArea = Math.max(maxArea, minHeight * width);
				}
    			heightStack.add(newHeight);
    			widthStack.add(width + 1);
			}
    	}
    	return maxArea;
    }
    
    public static void main(String [] args) {
    	largestRectangleArea(new int[]{2,1,2});
    }
}
