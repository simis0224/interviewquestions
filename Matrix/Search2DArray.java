package Matrix;
/**
	Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
	
	Integers in each row are sorted from left to right.
	The first integer of each row is greater than the last integer of the previous row.
	For example,
	
	Consider the following matrix:
	
	[
	  [1,   3,  5,  7],
	  [10, 11, 16, 20],
	  [23, 30, 34, 50]
	]
	Given target = 3, return true.
 */

public class Search2DArray {
    public static boolean searchMatrix(int[][] matrix, int target) {
    	// put the right end index.
    	int rowIndex = searchColumns(matrix, 0, matrix.length - 1, target);
    	if(rowIndex == -1) {
    		return false;
    	}
        return searchRow(matrix[rowIndex], 0, matrix[0].length - 1, target);
    }
    
    public static boolean searchRow(int[] row, int start, int end, int target) {
    	if(start > end) {
    		return false;
    	} else {
	    	int middle = (start + end) / 2;
	    	// be sure the compare with the middle element
	    	if(target == row[middle]) {
	    		return true;
	    	}else if(target < row[middle]) {
	    		return searchRow(row, start, middle - 1, target);
	    	} else {
	    		return searchRow(row, middle + 1, end, target);
	    	}
    	}
    }
    
    public static int searchColumns(int[][] matrix, int start, int end, int target) {
    	if(start > end || target < matrix[start][0] || target > matrix[end][matrix[0].length - 1]) {
    		return -1;
    	}
    	// don't forget start == end case, otherwise infinite loop
    	if(start == end) {
        	if(target >= matrix[start][0] && target <= matrix[start][matrix[0].length - 1]) {
        		return start;
        	} else {
        		return -1;
        	}
    	}  else {
    		// be sure to pick up the middle if target is within its range
	    	int middle = (start + end) / 2;
	    	if(target >= matrix[middle][0] && target <= matrix[middle][matrix[0].length - 1]) {
	    		return middle;
	    	} else if(target < matrix[middle][0]) {
	    		return searchColumns(matrix, start, middle - 1, target);
	    	} else {
	    		return searchColumns(matrix, middle + 1, end, target);
	    	}
	    }
    }
    
    public static void main(String [] args) {
    	searchMatrix(new int[][]{{1, 1}}, 1);
    }
}
