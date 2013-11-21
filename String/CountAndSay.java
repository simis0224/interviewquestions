package String;
/**
	The count-and-say sequence is the sequence of integers beginning as follows:
	1, 11, 21, 1211, 111221, ...
	
	1 is read off as "one 1" or 11.
	11 is read off as "two 1s" or 21.
	21 is read off as "one 2, then one 1" or 1211.
	
	Given an integer n, generate the nth sequence.
	
	Note: The sequence of integers will be represented as a string.
**/
public class CountAndSay {
    public static String countAndSay(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	
    	String result = "1";
    	for(int i = 1; i < n; i++) {
    		int count = 0;
    		String number = "";
    		String newResult = "";
    		for(int j = 0; j < result.length(); j++) {
    			if(j == 0) {
    				count = 1;
    				number = "" + result.charAt(j);
    			} else {
    				if(result.charAt(j) == result.charAt(j - 1)) {
    					count++;
    				} else {
    					newResult = newResult + count + number;
    					number = "" + result.charAt(j);
    					count = 1;
    				}
    			}
    		}
    		// don't forget for the case for the last segment with the same number
    		newResult = newResult + count + number;
    		result = newResult;
    	}
    	return result;
    }
    
    public static void main(String[] args) {
    	countAndSay(3);
    }
}
