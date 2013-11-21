package Matrix;
/**
	Follow up for "Unique Paths":
	
	Now consider if some obstacles are added to the grids. How many unique paths would there be?
	
	An obstacle and empty space is marked as 1 and 0 respectively in the grid.
	
	For example,
	
	There is one obstacle in the middle of a 3x3 grid as illustrated below.
	
	[
	  [0,0,0],
	  [0,1,0],
	  [0,0,0]
	]
	The total number of unique paths is 2.
	
	Note: m and n will be at most 100.
 */

public class UniquePathII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	int m = obstacleGrid.length;
    	int n = obstacleGrid[0].length;
        int[][] path = new int[m][n];
        
        for(int i = 0; i < n; i++) {
        	if(i == 0) {
        		path[0][0] = obstacleGrid[0][i] == 1 ? 0 : 1;
        	} else {
        		path[0][i] = obstacleGrid[0][i] == 1 ? 0 : path[0][i - 1];
        	}
        }
        
        for(int j = 1; j < m; j++) {
    		path[j][0] = obstacleGrid[j][0] == 1 ? 0 : path[j - 1][0];
        }
        
        for(int j = 1; j < m; j++) {
        	for(int i = 1; i < n; i++) {
        		path[j][i] = obstacleGrid[j][i] == 1 ? 0: path[j - 1][i] + path[j][i - 1];
        	}
        }
        
        return path[m - 1][n - 1];
    }
}
