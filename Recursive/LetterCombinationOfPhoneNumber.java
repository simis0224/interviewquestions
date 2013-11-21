package Recursive;
import java.util.ArrayList;

/**
	Given a digit string, return all possible letter combinations that the number could represent.
	
	A mapping of digit to letters (just like on the telephone buttons) is given below.
	
	Input:Digit string "23"
	Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
	
	Note:
	Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class LetterCombinationOfPhoneNumber {
    public ArrayList<String> letterCombinations(String digits) {
    	char[][] numCharMapping = new char[][] { 
    			new char[]{},
    			new char[]{'a', 'b', 'c'},
    			new char[]{'d', 'e', 'f'},
    			new char[]{'g', 'h', 'i'},
    			new char[]{'j', 'k', 'l'},
    			new char[]{'m', 'n', 'o'},
    			new char[]{'p', 'q', 'r', 's'},
    			new char[]{'t', 'u', 'v'},
    			new char[]{'w', 'x', 'y', 'z'}
    	};
    	
    	ArrayList<String> results = new ArrayList<String>();
    	letterCombinations(digits, digits.length(), numCharMapping, "", results);
        return results;
    }
    
    public void letterCombinations(String digits, int n, char[][] numCharMapping, String result, ArrayList<String> results) {
    	if(result.length() == n) {
    		results.add(result);
    		return;
    	}
    	
    	if(digits.length() == 0) {
    		return;
    	}
    	
    	for(int i = 0; i < numCharMapping[Integer.parseInt("" + digits.charAt(0)) - 1].length; i++) {
    		letterCombinations(digits.substring(1), n, numCharMapping, 
    				result + numCharMapping[Integer.parseInt("" + digits.charAt(0)) - 1][i], results);
    	}
    }
}
