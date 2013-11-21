package Recursive;
/**
	Follow up for N-Queens problem.
	
	Now, instead outputting board configurations, return the total number of distinct solutions.
 */
public class NQueensII {
    public int totalNQueens(int n) {
    	qPositions = new int[n];
    	sum = 0;
    	
    	solveNQueens(n, 0);
    	
    	return sum;
    }
    
	static int[] qPositions;
	static int sum;
	
    public static void solveNQueens(int n, int index) {
    	if(index == n) {
    		sum++;
    		return;
    	}
    	
    	for(int i = 0; i < n; i++) {
    		if(isValidPosition(i, index)) {
    			qPositions[index] = i;
    			solveNQueens(n, index + 1);
    		}
    	}
    }
    
    public static boolean isValidPosition(int position, int index) {
    	for(int i = 0; i < index; i++) {
    		if(qPositions[i] == position) {
    			return false;
    		}
    		
    		if(Math.abs(index - i) == Math.abs(position - qPositions[i])) {
    			return false;
    		}
    	}
    	
    	return true;
    }
    
}
