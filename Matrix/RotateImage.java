package Matrix;

/**
	You are given an n x n 2D matrix representing an image.
	
	Rotate the image by 90 degrees (clockwise).
	
	Follow up:
	Could you do this in-place?
 */
public class RotateImage {

    public void rotate(int[][] matrix) {
    	// don't forget empty case
    	if(matrix.length == 0) {
    		return;
    	}
    	// forget length - 1 for index
        rotate(matrix, 0, matrix.length - 1, 0, matrix[0].length - 1);
    }
    
    public void rotate(int[][] matrix, int sRow, int eRow, int sCol, int eCol) {
    	if(sRow > eRow || sCol > eCol) {
    		return;
    	}
    	
    	for(int i = 0; i < eCol - sCol; i++) {
    		int tmp = matrix[sRow][sCol + i];
    		matrix[sRow][sCol + i] = matrix[eRow - i][sCol];
    		matrix[eRow - i][sCol] = matrix[eRow][eCol - i];
    		matrix[eRow][eCol - i] = matrix[sRow + i][eCol];
    		matrix[sRow + i][eCol] = tmp;
    	}
    	
    	rotate(matrix, sRow + 1, eRow - 1, sCol + 1, eCol - 1);
    }
    
}
