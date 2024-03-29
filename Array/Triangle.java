package Array;


import java.util.ArrayList;
/**
	Given a triangle, find the minimum path sum from top to bottom. Each step 
	you may move to adjacent numbers on the row below.
	
	For example, given the following triangle
	
	[
	     [2],
	    [3,4],
	   [6,5,7],
	  [4,1,8,3]
	]
	The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
	
	Note:
	Bonus point if you are able to do this using only O(n) extra space, where n 
	is the total number of rows in the triangle.
 */
public class Triangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int[] minSum = new int[triangle.size()];
        
        minSum[0] = triangle.get(0).get(0);
        int min = minSum[0];
        for(int i = 1; i < triangle.size(); i ++) {
        	min = Integer.MAX_VALUE;
        	for(int j = i; j >=0; j--) {
        		if(j == i) {
        			minSum[j] = triangle.get(i).get(j) + minSum[j - 1];
        		} else if(j == 0){
        			minSum[j] = triangle.get(i).get(j) + minSum[j];
        		} else {
        			minSum[j] = Math.min(minSum[j], minSum[j - 1]) + triangle.get(i).get(j);
        		}
        		min = Math.min(min, minSum[j]);
        	}
        }
        return min;
    }
    
    public static void main(String[] args) {
    }
}
