package Matrix;

import java.util.HashSet;

/**
	Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
	
	The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
	
	
	
	A partially filled sudoku which is valid.
 */

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < board.length; i++) {
        	if(!isRowValid(board, i)) {
        		return false;
        	}
        }
        
        for(int i = 0; i < board[0].length; i++) {
        	if(!isColValid(board, i)) {
        		return false;
        	}
        }
        
        for(int i = 0; i < board.length; i = i + 3) {
        	for(int j = 0; j < board[0].length; j = j + 3) {
        		if(!isGridValid(board, i, j)) {
        			return false;
        		}
        	}
        }
        
        return true;
    }
    
    boolean isRowValid(char[][] board, int rowIndex) {
    	HashSet<Character> numbers = new HashSet<Character>();
    	for(int i = 0; i < board[0].length; i++) {
    		if(board[rowIndex][i] >= '1' && board[rowIndex][i] <= '9') {
    			if(numbers.contains(board[rowIndex][i])) {
    				return false;
    			} else {
    				numbers.add(board[rowIndex][i]);
    			}
    		}
    	}
    	return true;
    }
    
    boolean isColValid(char[][] board, int colIndex) {
    	HashSet<Character> numbers = new HashSet<Character>();
    	for(int i = 0; i < board.length; i++) {
    		if(board[i][colIndex] >= '1' && board[i][colIndex] <= '9') {
    			if(numbers.contains(board[i][colIndex])) {
    				return false;
    			} else {
    				numbers.add(board[i][colIndex]);
    			}
    		}
    	}
    	return true;
    }
    
    boolean isGridValid(char[][] board, int row, int col) {
    	HashSet<Character> numbers = new HashSet<Character>();
    	for(int i = row; i < row + 3; i++) {
    		for(int j = col; j < col + 3; j++) {
        		if(board[i][j] >= '1' && board[i][j] <= '9') {
        			if(numbers.contains(board[i][j])) {
        				return false;
        			} else {
        				numbers.add(board[i][j]);
        			}
        		}
    		}
    	}
    	return true;
    }
}
