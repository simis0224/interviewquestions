package Recursive;
/**
	Given a 2D board and a word, find if the word exists in the grid.
	
	The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are 
	those horizontally or vertically neighboring. The same letter cell may not be used more than once.
	
	For example,
	Given board =
	
	[
	  ["ABCE"],
	  ["SFCS"],
	  ["ADEE"]
	]
	word = "ABCCED", -> returns true,
	word = "SEE", -> returns true,
	word = "ABCB", -> returns false.
 */
public class WordSearch {
	
	static char[][] visited = null;
	
    public static boolean exist(char[][] board, String word) {
    	visited = new char[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
        	for(int j = 0; j < board[0].length; j++) {
        		visited[i][j] = 0;
        	}
        }
        
         // remember to break twice
        boolean found = false;
        for(int i = 0; i < board.length; i++) {
        	for(int j = 0; j < board[0].length; j++) {
        		if(!found) {
        			found = dfs(board, i, j, word);
        		}
        	}
        }
        
        return found;
    }
    
    public static boolean dfs(char[][] board, int p, int q, String word) {
    	
    	if(word == null || word.length() == 0) {
    		return true;
    	}
    	
    	if( (p < 0 || p > board.length - 1 || q < 0 || q > board[0].length - 1) && word.length() > 0) {
    		return false;
    	}
    	
    	if(visited[p][q] == 1 ||word.charAt(0) != board[p][q]) {
    		return false;
    	}
    	
    	boolean found = false;
    	visited[p][q] = 1;
    	found = found || dfs(board, p + 1, q, word.substring(1));
    	if(!found) {
    		found = found || dfs(board, p, q + 1, word.substring(1));
    	}
    	if(!found) {
    		found = found || dfs(board, p - 1, q, word.substring(1));
    	}
    	if(!found) {
    		found = found || dfs(board, p, q - 1, word.substring(1));
    	}
    	visited[p][q] = 0;
    	return found;
    }
    
    public static void main(String [] args) {
    	exist(new char[][]{{'a' , 'b'}, {'c', 'd'}}, "acdb");
    }
}
