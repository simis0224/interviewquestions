package String;

/**
	Given a string S, find the longest palindromic substring in S. You may assume that 
	the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 */

// O(n) approach http://leetcode.com/2011/11/longest-palindromic-substring-part-ii.html
public class LongestPalindromic {
    public static String longestPalindrome(String s) {
    	String maxSubstring = "";
    	String s2 = "";
    	for(int i = 0; i < s.length(); i++) {
    		s2 += "#" + s.charAt(i);
    	}
    	s2 += "#";
    	
    	System.out.println(s2);
    	
    	for(int i = 0; i < s2.length(); i++) {
    		int j = 1;
    		for(; i + j <s2.length() && i - j >=0; j++) {
    			if(s2.charAt(i - j) != s2.charAt(i + j)) {
    				break;
    			} 
    		}
    		
    		System.out.println(s2.substring(i - j + 1, i + j - 1));
    		String tmp = s2.substring(i - j + 1, i + j - 1).replace("#", "");
    		if(tmp.length() > maxSubstring.length()) {
    			maxSubstring = tmp;
    			System.out.println(tmp);
    		}
    		if(maxSubstring.length() == s.length()) {
    			break;
    		} 
    	}
    	return maxSubstring;
        
    }
    
    public static void main(String [] args) {
    	String k = longestPalindrome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    	System.out.println(k);
    }
}
