package Matrix;
/**
	Given a m x n grid filled with non-negative numbers, find a path from top left to 
	bottom right which minimizes the sum of all numbers along its path.
	
	Note: You can only move either down or right at any point in time.
 */

public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int[][] sum = new int[grid.length][grid[0].length];
        
        for(int i = 0; i < grid[0].length; i++) {
        	sum[0][i] = i == 0? grid[0][0] : (sum[0][i - 1] + grid[0][i]);
        }
        
        for(int j = 1; j < grid.length; j++) {
        	sum[j][0] = sum[j - 1][0] + grid[j][0];
        }
        
        for(int j = 1; j < grid.length; j++) {
        	for(int i = 1; i < grid[0].length; i++) {
        		sum[j][i] = Math.min(sum[j - 1][i], sum[j][i - 1]) + grid[j][i];
        	}
        }
        
        return sum[grid.length - 1][grid[0].length - 1];
    }
}
