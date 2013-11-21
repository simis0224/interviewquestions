package Matrix;
/**
	Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
	
	A region is captured by flipping all 'O's into 'X's in that surrounded region .
	
	For example,
	
	X X X X
	X O O X
	X X O X
	X O X X
	After running your function, the board should be:
	
	X X X X
	X X X X
	X X X X
	X O X X
 */

public class SurroundedRegions {
    public static void solve(char[][] board) {
        
    	markFromEdge(board);
    	
    	// always calculate row first
    	for(int j = 0; j < board.length; j++) {
    		for(int i = 0; i < board[0].length; i++) {
    			if(board[j][i] == 'O') {
    				board[j][i] = 'X';
    			} else if(board[j][i] == 'E') {
    				board[j][i] = 'O';
    			}
    		}
    	}
    }
    
    public static void markFromEdge(char[][] board) {
    	if(board.length == 0) {
    		return;
    	}
    	
    	// full first row starting from 0 to end of row
    	int[][] visited = new int[board.length][board[0].length];
    	for(int i = 0; i <= board[0].length - 1; i++) {
    		markFromEdge(board, i, 0, visited);
    	}
    	
    	for(int i = 1; i < board.length - 1; i++) {
    		markFromEdge(board, board[0].length - 1, i, visited);
    	}
    	
    	if(board.length > 1) {
	    	for(int i = board[0].length - 1; i > 0; i--) {
	    		markFromEdge(board, i, board.length - 1, visited);
	    	}
    	}
    	
    	if(board[0].length > 1) {
	    	for(int i = board.length - 1; i > 0; i--) {
	    		markFromEdge(board, 0, i, visited);
	    	}
    	}
    }
    
    public static void markFromEdge(char[][] board, int x, int y, int[][] visited) {
    	// don't forget board[y][x] == 'X'
    	if(visited[y][x] == 1 || board[y][x] == 'X') {
    		return;
    	}
    	
    	visited[y][x] = 1;
    	
    	board[y][x] = 'E';
    	if(x + 1 <= board[0].length - 1)
    		markFromEdge(board, x + 1, y, visited);
    	if(y + 1 <= board.length - 1)
    		markFromEdge(board, x, y + 1, visited);
    	if(x - 1 >= 0)
    		markFromEdge(board, x - 1, y, visited);
    	if(y - 1 >= 0)
    		markFromEdge(board, x, y - 1, visited);
    }
    
    public static void main(String[] arg) {
    	solve(new char[][]{{'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X',
    		'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X',
    		'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X',
    		'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X',
    		'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X',
    		'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X',
    		'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X',
    		'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X',
    		'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X',
    		'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X',
    		'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X',
    		'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','O'}});
    }
}
