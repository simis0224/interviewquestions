package Matrix;


import java.util.HashSet;

/**
	Write a program to solve a Sudoku puzzle by filling the empty cells.
	
	Empty cells are indicated by the character '.'.
	
	You may assume that there will be only one unique solution.
	
	A sudoku puzzle...
	
	...and its solution numbers marked in red.
 */

public class SudokuSolver {
    public static void solveSudoku(char[][] board) {
    	
    	doSolveSudoku(board, 0, 0);
    	
    	return;
    }
    
    public static boolean doSolveSudoku(char[][] board, int row, int col) {
    	if(row == board.length && col == 0) {
    		return true;
    	}
    	
    	
    	if(board[row][col] == '.') {
			for(char k = '1'; k <= '9'; k++) {
				board[row][col] = k;
				// isGridValid input row / 3 * 3, col / 3 * 3
				if(isRowValid(board, row) && isColValid(board, col) && isGridValid(board, row/3 * 3, col/3 * 3)) {
					boolean foundSolution = doSolveSudoku(board, row + (col + 1 == board[0].length ? 1 : 0), (col + 1) % board[0].length);
					if(foundSolution) {
						return true;
					}
				}  
				board[row][col] = '.';
			}
    	} else {
    		boolean foundSolution = doSolveSudoku(board, row + (col + 1 == board[0].length ? 1 : 0), (col + 1) % board[0].length);
			if(foundSolution) {
				return true;
			}
    	}
    	return false;
    } 
    
    
    static boolean isRowValid(char[][] board, int rowIndex) {
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
    
    static boolean isColValid(char[][] board, int colIndex) {
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
    
    static boolean isGridValid(char[][] board, int row, int col) {
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
    
    public static void main(String[] args) {
    	//["..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."]	
    	solveSudoku(new char[][]{
    			{'.','.','9','7','4','8','.','.','.'}, 
    			{'7','.','.','.','.','.','.','.','.'},
    			{'.','2','.','1','.','9','.','.','.'},
    			{'.','.','7','.','.','.','2','4','.'},
    			{'.','6','4','.','1','.','5','9','.'},
    			{'.','9','8','.','.','.','3','.','.'},
    			{'.','.','.','8','.','3','.','2','.'},
    			{'.','.','.','.','.','.','.','.','6'},
    			{'.','.','.','2','7','5','9','.','.'}});
    }
}
