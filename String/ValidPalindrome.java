package String;
/**
	Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
	
	For example,
	"A man, a plan, a canal: Panama" is a palindrome.
	"race a car" is not a palindrome.
	
	Note:
	Have you consider that the string might be empty? This is a good question to ask during an interview.
	
	For the purpose of this problem, we define empty string as valid palindrome.
 */

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        int p = 0, q = s.length() - 1;
        while(p < q) {
            // don't forget p, q limit
        	// don't forget filter out non alpha numeric char
        	while(p < q && ! isAlphanumeric(s.charAt(p))) {
        		p++;
        	}
        	

        	while(q > p && ! isAlphanumeric(s.charAt(q))) {
        		q--;
        	}
            
            if(p >= q) {
                break;
            }
        	
        	if(!isSameChar(s.charAt(p), s.charAt(q))) {
        		return false;
        	}
            
            p++;
            q--;

        }
        return true;
    }
    
    static boolean isAlphanumeric(char c) {
    	return c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z' || c >= '0' && c <= '9';
    }
    
    static boolean isSameChar(char c1, char c2) {
    	return c1 == c2 || 
    			c1 >= 'a' && c1 <= 'z' && c1 + 'A' - 'a' == c2 ||
    			c1 >= 'A' && c1 <= 'Z' && c1 == c2 + 'A' - 'a';
    }
    
    public static void main(String[] arg) {
    	isPalindrome("a.");
    }
}
