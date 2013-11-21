package String;

import java.util.Arrays;
import java.util.HashMap;

/**
	Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
	
	Below is one possible representation of s1 = "great":
	
	    great
	   /    \
	  gr    eat
	 / \    /  \
	g   r  e   at
	           / \
	          a   t
	To scramble the string, we may choose any non-leaf node and swap its two children.
	
	For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
	
	    rgeat
	   /    \
	  rg    eat
	 / \    /  \
	r   g  e   at
	           / \
	          a   t
	We say that "rgeat" is a scrambled string of "great".
	
	Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
	
	    rgtae
	   /    \
	  rg    tae
	 / \    /  \
	r   g  ta  e
	       / \
	      t   a
	We say that "rgtae" is a scrambled string of "great".
	
	Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 */

public class ScrambleString {
	
	static HashMap<String, Boolean> cached = new HashMap<String, Boolean>();
	
    public static boolean isScramble(String s1, String s2) {
    	
    	String cachedKey = s1 + "-" + s2;
    	
    	if(cached.containsKey(cachedKey)) {
    		return cached.get(cachedKey);
    	}
    	
    	if(s1.equals(s2)) {
    		cached.put(cachedKey, true);
    		return true;
    	}
    	
        if(s1.length() != s2.length()) {
        	cached.put(cachedKey, false);
        	return false;
        }
        
        char[] charArray = s1.toCharArray();
        Arrays.sort(charArray);
        String sortedS1 = String.valueOf(charArray);
        
        charArray = s2.toCharArray();
        Arrays.sort(charArray);
        String sortedS2 = String.valueOf(charArray);
        
        if(!sortedS1.equals(sortedS2)) {
        	cached.put(cachedKey, false);
        	return false;
        }
        
        for(int i = 1; i < s1.length(); i++) {
        	String s11 = s1.substring(0, i);
        	String s12 = s1.substring(i, s1.length());
        	
        	String s21 = s2.substring(s2.length() - i, s2.length());
        	String s22 = s2.substring(0, s2.length() - i);
        	
        	if(isScramble(s11, s21) && isScramble(s12, s22)) {
        		cached.put(cachedKey, true);
        		return true;
        	}
        	
        	String s31 = s2.substring(0, i);
        	String s32 = s2.substring(i, s2.length());
        	
        	if(isScramble(s11, s31) && isScramble(s12, s32)) {
        		cached.put(cachedKey, true);
        		return true;
        	}
        }
        cached.put(cachedKey, false);
        return false;
    }
    
    public static void main(String[] args) {
    	isScramble("great", "rgtae");
    }
}
