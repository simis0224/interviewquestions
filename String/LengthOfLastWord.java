package String;

/**
	Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
	return the length of last word in the string.
	
	If the last word does not exist, return 0.
	
	Note: A word is defined as a character sequence consists of non-space characters only.
	
	For example, 
	Given s = "Hello World",
	return 5.
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	int count = 0;
    	boolean hasScannedLetter = false;;
        for(int i = s.length() - 1; i >= 0; i--) {
        	if(!isLetter(s.charAt(i))) {
        		if(hasScannedLetter) {
        			break;
        		} 
        	} else {
        		count++;
        		hasScannedLetter = true;
        	}
        }
        return count;
    }
    
    public boolean isLetter(char c) {
    	if(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
    		return true;
    	} else {
    		return false;
    	}
    }
}
