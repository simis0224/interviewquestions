package Recursive;


import java.util.ArrayList;
import java.util.Arrays;
/**
	The n-queens puzzle is the problem of placing n queens on an n�n chessboard such 
	that no two queens attack each other.
	
	Given an integer n, return all distinct solutions to the n-queens puzzle.
	
	Each solution contains a distinct board configuration of the n-queens' placement,
	where 'Q' and '.' both indicate a queen and an empty space respectively.
	
	For example,
	There exist two distinct solutions to the 4-queens puzzle:
	
	[
	 [".Q..",  // Solution 1
	  "...Q",
	  "Q...",
	  "..Q."],
	
	 ["..Q.",  // Solution 2
	  "Q...",
	  "...Q",
	  ".Q.."]
	]
 */
public class NQueens {
	
	static int[] qPositions;
	static ArrayList<int[]> goodPositions;
	static ArrayList<String[]> results;
	static String[] line;
	
    public static ArrayList<String[]> solveNQueens(int n) {
    	qPositions = new int[n];
    	line = new String[n];
    	goodPositions = new ArrayList<int[]>();
    	results = new ArrayList<String[]>();
    	for(int i = 0; i < n; i++) {
    		qPositions[i] = -1;
    	}
    	
    	solveNQueens(n, 0);
    	
    	return results;
    	
    }
    
    public static void solveNQueens(int n, int index) {
    	if(index == n) {
    		int[] goodPosition = Arrays.copyOf(qPositions, n);
    		goodPositions.add(goodPosition);
    		String[] result = Arrays.copyOf(line, n);
    		results.add(result);
    		return;
    	}
    	
    	for(int i = 0; i < n; i++) {
    		if(isValidPosition(i, index)) {
    			qPositions[index] = i;
    			line[index] = printOutQueenPosition(n, i);
    			solveNQueens(n, index + 1);
    			line[index] = printOutQueenPosition(n, -1);
    			qPositions[index] = -1;
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
    
    public static String printOutQueenPosition(int n, int index) {
    	String line = "";
    	for(int i = 0; i < n; i++) {
    		if(i == index) {
    			line += "Q";
    		} else {
    			line += ".";
    		}
    	}
    	return line;
    }
    
    public static void main(String[] args) {
    	solveNQueens(2);
    }
}
