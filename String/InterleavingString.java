package String;
import java.util.HashMap;

/**
	Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
	
	For example,
	Given:
	s1 = "aabcc",
	s2 = "dbbca",
	
	When s3 = "aadbbcbcac", return true.
	When s3 = "aadbbbaccc", return false.
 */

public class InterleavingString {
	
	static HashMap<String, Boolean> cached;
	
	public static boolean isInterleave(String s1, String s2, String s3) {
		cached = new HashMap<String, Boolean>();
		
		return doIsInterleave(s1, s2, s3);
	}
	
    public static boolean doIsInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(cached.containsKey(s1 + "-" + s2 + "-" + s3)) {
    		return cached.get(s1 + "-" + s2 + "-" + s3);
    	}
    	
        if(s1.length() == 0 && s2.length() == 0 && s3.length() == 0) {
        	cached.put(s1 + "-" + s2 + "-" + s3, true);
        	return true;
        }
        
        boolean matchS1 = false;
        // s3 length great than zero
        if(s1.length() > 0 && s3.length() > 0 && s1.charAt(0) == s3.charAt(0)) {
        	matchS1 = doIsInterleave(s1.substring(1), s2, s3.substring(1));
        }
        
        boolean matchS2 = false;
        if(!matchS1 && s2.length() > 0 && s3.length() > 0 && s2.charAt(0) == s3.charAt(0)) {
        	matchS2 = doIsInterleave(s1, s2.substring(1), s3.substring(1));
        }
        
        
        cached.put(s1 + "-" + s2 + "-" + s3, matchS1 || matchS2);
        
        return matchS1 || matchS2;
    }
    
    public static void main(String[] args) {
    	isInterleave("", "", "a");
    }
    
}
