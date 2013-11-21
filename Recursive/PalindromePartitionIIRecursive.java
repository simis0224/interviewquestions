package Recursive;

import java.util.HashMap;
/**
	Given a string s, partition s such that every substring of the partition is a palindrome.
	
	Return the minimum cuts needed for a palindrome partitioning of s.
	
	For example, given s = "aab",
	Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */
public class PalindromePartitionIIRecursive {
	
	static HashMap<String, Integer> cache;
	static HashMap<String, Boolean> cacheIsPalin;
	static int mininumCut;
	
	public static int minCut(String s) {
		cache = new HashMap<String, Integer>();
		cacheIsPalin = new HashMap<String, Boolean>();
		mininumCut = Integer.MAX_VALUE;
		doMinCut(s, 0);
		return mininumCut;
	}
	
    public static int doMinCut(String s, int cutNum) {
    	if(cache.containsKey(s)) {
    		return cache.get(s);
    	}
    	
    	if(s.length() <= 1 || isPalindrome(s)) {
    		cache.put(s, 0);
    		mininumCut = Math.min(mininumCut, cutNum);
    		return cutNum;
    	}
    	
    	if(cutNum >= mininumCut) {
    		return mininumCut;
    	}
    	
    	int minCut = Integer.MAX_VALUE;
    	for(int i = 1; i < s.length() ; i++) {
    		String s1 = s.substring(0, i);
    		if(isPalindrome(s1)) {
    			int cut = doMinCut(s.substring(i), cutNum + 1);
    			minCut = Math.min(minCut, cut) + 1;
    			mininumCut = Math.min(mininumCut, minCut + cutNum) ;
    		}
    	}
        
    	cache.put(s, minCut);
    	return minCut;
    }
    
    public static boolean isPalindrome(String s) {
    	if(cacheIsPalin.containsKey(s)) {
    		return cacheIsPalin.get(s);
    	}
    	
    	if(s.length() > 1 && s.charAt(0) == s.charAt(s.length() - 1) &&
    			cacheIsPalin.containsKey(s.substring(1, s.length() - 1)) &&
    			cacheIsPalin.get(s.substring(1, s.length() - 1))) {
    		cacheIsPalin.put(s, true);
    		return true;
    	}
    	
    	int p = 0, q = s.length() - 1;
    	while(p < q) {
    		if(s.charAt(p) != s.charAt(q)) {
    			cacheIsPalin.put(s, false);
    			return false;
    		}
    		p++;
    		q--;
    	}
    	cacheIsPalin.put(s, true);
    	return true;
    }
    
    public static void main(String[] args) {
    	minCut("ab");
    }
}
