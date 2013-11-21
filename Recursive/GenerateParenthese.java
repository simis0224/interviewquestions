package Recursive;
import java.util.ArrayList;

/**
	Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
	
	For example, given n = 3, a solution set is:
	
	"((()))", "(()())", "(())()", "()(())", "()()()"
 */

public class GenerateParenthese {
    public ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	ArrayList<String> results = new ArrayList<String>();
    	generateParenthese("", n, 0, 0, results);
    	return results;
        
    }
    
    public void generateParenthese(String s, int n, int numOpenParenthese, int numCloseParenthese, ArrayList<String> results) {
    	if(s.length() == n * 2 && numOpenParenthese == numCloseParenthese) {
    		results.add(s);
    		return;
    	}
    	
    	if(numOpenParenthese <= n) {
	    	if(numOpenParenthese == numCloseParenthese) {
	    		generateParenthese(s + "(", n, numOpenParenthese + 1, numCloseParenthese, results);
	    	} 
	    	
	    	if(numOpenParenthese > numCloseParenthese) {
	    		generateParenthese(s + "(", n, numOpenParenthese + 1, numCloseParenthese, results);
	    		generateParenthese(s + ")", n, numOpenParenthese, numCloseParenthese + 1, results);
	    	}
    	}
    }
}
