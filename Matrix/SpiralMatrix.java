package Matrix;
import java.util.ArrayList;

/**
	Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
	
	For example,
	Given the following matrix:
	
	[
	 [ 1, 2, 3 ],
	 [ 4, 5, 6 ],
	 [ 7, 8, 9 ]
	]
	You should return [1,2,3,6,9,8,7,4,5].
 */

public class SpiralMatrix {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> result = new ArrayList<Integer>();
        // 2d array. run below code only when there is at least one row
        if(matrix.length > 0) {
        	spiralOrder(matrix, 0, matrix[0].length - 1, 0, matrix.length - 1, result);
        }
        return result;
    }
    
    public void spiralOrder(int[][] matrix, int rs, int re, int cs, int ce, ArrayList<Integer> result) {
    	if(rs > re || cs > ce) {
    		return;
    	}
    	
    	for(int i = rs; i <= re; i++) {
    		result.add(matrix[cs][i]);
    	}
    	
    	for(int i = cs + 1; i <= ce; i++) {
    		result.add(matrix[i][re]);
    	}
    	
    	// remember if only one row or one colum, don't scan it again
    	if(ce > cs) {
	    	for(int i = re - 1; i >= rs; i--) {
	    		result.add(matrix[ce][i]);
	    	}
    	}
    	
    	if(re > rs) {
    		for(int i = ce - 1; i >= cs +1; i--) {
    			result.add(matrix[i][rs]);
    		}
    	}
    	
    	spiralOrder(matrix, rs + 1, re - 1, cs + 1, ce - 1, result);
    }
}
