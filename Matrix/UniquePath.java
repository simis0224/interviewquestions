package Matrix;
/**
	A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
	
	The robot can only move either down or right at any point in time. The robot is trying to reach 
	the bottom-right corner of the grid (marked 'Finish' in the diagram below).
	
	How many possible unique paths are there?
	
	
	
	Above is a 3 x 7 grid. How many possible unique paths are there?
	
	Note: m and n will be at most 100.
	 */

public class UniquePath {
    public int uniquePaths(int m, int n) {
        int[][] path = new int[m][n];
        
        for(int i = 0; i < n; i++) {
        	path[0][i] = 1;
        }
        
        for(int j = 1; j < m; j++) {
        	path[j][0] = 1;
        }
        
        for(int j = 1; j < m; j++) {
        	for(int i = 1; i < n; i++) {
        		path[j][i] = path[j - 1][i] + path[j][i - 1];
        	}
        }
        
        return path[m - 1][n - 1];
    }
}
