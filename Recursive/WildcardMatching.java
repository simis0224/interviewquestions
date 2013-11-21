package Recursive;

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
public class WildcardMatching {
	
    public static boolean isMatch2(String s, String p) {
    	if(s.length() == 0 && p.length() == 0) {
    		return true;
    	}
    	
    	if(s.length() > 0 && p.length() == 0) {
    		return false;
    	}
    	
    	if(s.length() == 0) {
    		return p.replace("*", "").length() == 0;
    	}
    	
    	int[][] dp = new int[s.length() + 1][2];
    	
    	dp[0][0] = 1;
    	for(int i = 1; i <= s.length(); i++) {
    		dp[i][0%2] = 0;
    	}
    	
    	for(int j = 1; j <= p.length(); j++) {
    		if(dp[0][(j - 1)%2] == 1 && p.charAt(p.length() - j) == '*') {
    			dp[0][j%2] = 1;
    		} else {
    			dp[0][j%2] = 0;
    		}
    	}
    	
    	for(int i = 1; i <= s.length(); i++) {
    		for(int j = 1; j <= p.length(); j++) {
    			if(dp[i - 1][(j - 1)%2] == 1 && 
    					(s.charAt(s.length() - i) == p.charAt(p.length() - j) || p.charAt(p.length() - j) == '?')) {
    				dp[i][j%2] = 1;
    				continue;
    			}
    			
    			if(p.charAt(p.length() - j) == '*') {
    				for(int k = i; k >= 0 ; k--) {
    					if(dp[k][(j - 1)%2] == 1) {
    						dp[i][j%2] = 1;
    						break;
    					}
    				}
    			}
    		}
    	}
    	
    	return dp[s.length()][p.length()%2] == 1;
    }
	
	
    public static boolean isMatch(String s, String p) {
    	if(s.length() == 0 && p.length() == 0) {
    		return true;
    	}
    	
    	if(s.length() > 0 && p.length() == 0) {
    		return false;
    	}
    	
    	if(s.length() == 0) {
    		return p.replace("*", "").length() == 0;
    	}
    	
    	int[][] dp = new int[s.length() + 1][p.length() + 1];
    	
    	dp[0][0] = 1;
    	for(int i = 1; i <= s.length(); i++) {
    		dp[i][0] = 0;
    	}
    	
    	for(int j = 1; j <= p.length(); j++) {
    		if(dp[0][j - 1] == 1 && p.charAt(p.length() - j) == '*') {
    			dp[0][j] = 1;
    		} else {
    			dp[0][j] = 0;
    		}
    	}
    	
    	for(int i = 1; i <= s.length(); i++) {
    		for(int j = 1; j <= p.length(); j++) {
    			if(dp[i - 1][j - 1] == 1 && 
    					(s.charAt(s.length() - i) == p.charAt(p.length() - j) || p.charAt(p.length() - j) == '?')) {
    				dp[i][j] = 1;
    				continue;
    			}
    			
    			if(p.charAt(p.length() - j) == '*') {
    				for(int k = i; k >= 0 ; k--) {
    					if(dp[k][j - 1] == 1) {
    						dp[i][j] = 1;
    						break;
    					}
    				}
    			}
    		}
    	}
    	
    	return dp[s.length()][p.length()] == 1;
    }
    
    public static void main(String[] args) {
    	isMatch2("aab", "c*a*b");
    }
    
}
