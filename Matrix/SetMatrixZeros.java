package Matrix;

/**
	Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 */

public class SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        boolean firstRowHasZero = false;
        boolean firstColumnHasZero = false;
        for(int i = 0; i < matrix[0].length; i++) {
        	if(matrix[0][i] == 0) {
        		firstRowHasZero = true;
        		break;
        	}
        }
        
        for(int j = 0; j < matrix.length; j++) {
        	if(matrix[j][0] == 0) {
        		firstColumnHasZero = true;
        		break;
        	}
        }
        
        // start from index 1
        for(int j = 1; j < matrix.length; j++) {
        	for(int i = 1; i < matrix[0].length; i++) {
        		if(matrix[j][i] == 0) {
        			matrix[j][0] = 0;
        			matrix[0][i] = 0;
        		}
        	}
        }
        
        // start from index 1
        for(int i = 1; i < matrix[0].length; i++) {
        	if(matrix[0][i] == 0) {
        		for(int j = 0; j < matrix.length; j++) {
        			matrix[j][i] = 0;
        		}
        	}
        }
        
        // start from index 1
        for(int j = 1; j < matrix.length; j++) {
        	if(matrix[j][0] == 0) {
        		for(int i = 0; i < matrix[0].length; i++) {
        			matrix[j][i] = 0;
        		}
        	}
        }
        
        // process index 0
        if(firstRowHasZero) {
    		for(int i = 0; i < matrix[0].length; i++) {
    			matrix[0][i] = 0;
    		}
        }
        
        if(firstColumnHasZero) {
    		for(int j = 0; j < matrix.length; j++) {
    			matrix[j][0] = 0;
    		}
        }
    }
}
