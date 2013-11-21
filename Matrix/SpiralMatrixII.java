package Matrix;

/**
	Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
	
	For example,
	Given n = 3,
	
	You should return the following matrix:
	[
	 [ 1, 2, 3 ],
	 [ 8, 9, 4 ],
	 [ 7, 6, 5 ]
	]
 */

public class SpiralMatrixII {
    public static int[][] generateMatrix(int n) {
    	int[][] result = new int[n][n];
        if(n > 0) {
        	generateMatrix(1, 0, n - 1, 0 , n - 1, result);
        }
        return result;
    }
    
    public static void generateMatrix(int startNum, int rs, int re, int cs, int ce, int[][] result) {
    	if(rs > re || cs > ce) {
    		return;
    	}
    	
    	for(int i = rs; i <= re; i++) {
    		result[cs][i] = startNum ++;
    	}
    	
    	for(int i = cs + 1; i <= ce; i++) {
    		result[i][re] = startNum++;
    	}
    	
    	if(ce > cs) {
    		for(int i = re - 1; i >= rs; i--) {
    			result[ce][i] = startNum++;
    		}
    	}
    	
    	if(re > rs) {
    		for(int i = ce - 1; i >= cs + 1; i--) {
    			result[i][rs] = startNum++;
    		}
    	}
    	
    	generateMatrix(startNum, rs + 1, re - 1, cs + 1, ce - 1, result);
    }
    
    public static void main(String [] args) {
    	generateMatrix(3);
    }
}
