package Recursive;

import java.util.HashMap;

/**
	Implement wildcard pattern matching with support for '?' and '*'.
	
	'?' Matches any single character.
	'*' Matches any sequence of characters (including the empty sequence).
	
	The matching should cover the entire input string (not partial).
	
	The function prototype should be:
	bool isMatch(const char *s, const char *p)
	
	Some examples:
	isMatch("aa","a") ? false
	isMatch("aa","aa") ? true
	isMatch("aaa","aa") ? false
	isMatch("aa", "*") ? true
	isMatch("aa", "a*") ? true
	isMatch("ab", "?*") ? true
	isMatch("aab", "c*a*b") ? false
 */
public class WildcardMatchingRecursive {
	
	static HashMap<String, Boolean> cache;
	
	public static boolean isMatch(String s, String p) {
		cache = new HashMap<String, Boolean>();
		return doMatch(s, p);
	}
	
    public static boolean doMatch(String s, String p) {
    	String key = s + "-" + p;
    	if(cache.containsKey(key)) {
    		return cache.get(key);
    	}
    	
    	if(s.length() == 0 && p.length() == 0) {
    		cache.put(key, true);
    		return true;
    	}
    	
    	if(s.length() > 0 && p.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?')) {
    		return doMatch(s.substring(1), p.substring(1));
    	}
    	
    	if(p.length() > 0 && p.charAt(0) == '*') {
    		int k = 0;
    		for(; k < p.length(); k++) {
    			if(p.charAt(k) != '*') {
    				break;
    			}
    		}
    		for(int i = 0; i <= s.length(); i++) {
    			boolean match = doMatch(s.substring(i), p.substring(k));
    			if(match) {
    				cache.put(key, true);
    				return true;
    			}
    		}
    		
    	}
    	cache.put(key, false);
    	return false;
    }
    
    public static void main(String[] args) {
    	isMatch("babbbbaabababaabbababaababaabbaabababbaaababbababaaaaaabbabaaaabababbabbababbbaaaababbbabbbbbbbbbbaabbb", 
    			"b**bb**a**bba*b**a*bbb**aba***babbb*aa****aabb*bbb***a");
    }
}
