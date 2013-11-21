package Recursive;

import java.util.HashMap;
import java.util.Map;
/**
	Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. 
	(each operation is counted as 1 step.)
	
	You have the following 3 operations permitted on a word:
	
	a) Insert a character
	b) Delete a character
	c) Replace a character
*/
public class EditDistanceRecursive {
	
	public static Map<String, Integer> cache;
	
	
	public static int minDistance(String word1, String word2) {
		cache = new HashMap<String, Integer>();
		doMinDistance(word1, word2);
		return cache.get(word1 + "-" + word2);
	}
	
    public static int doMinDistance(String word1, String word2) {
    	if(cache.containsKey(word1 + "-" + word2)) {
    		return cache.get(word1 + "-" + word2);
    	}
    	
    	if(word1.length() == 0) {
    		cache.put(word1 + "-" + word2, word2.length());
    		return word2.length();
    	}
    	
    	if(word2.length() == 0) {
    		cache.put(word1 + "-" + word2, word1.length());
    		return word1.length();
    	}
    	
    	if(word1.equals(word2)) {
    		cache.put(word1 + "-" + word2, 0);
    		return 0;
    	}
    	
    	int minDistance = Integer.MAX_VALUE;
    	// s1 = a[s11], s2 = a[s21], continue check s11 and s21
    	if(word1.charAt(0) == word2.charAt(0)) {
    		minDistance = Math.min(minDistance, 
    				doMinDistance(word1.substring(1, word1.length()), word2.substring(1, word2.length())));
    	} else {
    		// s1 = a[s11], s2 = b[s21]
    		
    		// replace a with b, continue check s11 and s21
    		minDistance = Math.min(minDistance, 
    				doMinDistance(word1.substring(1, word1.length()), word2.substring(1, word2.length())) + 1);
    		
    		// add b to s11, continue check s1 and s21
	    	minDistance = Math.min(minDistance, 
	    			doMinDistance(word1, word2.substring(1, word2.length())) + 1);
    		
	    	// remove a from s1, continue check s11 and s2
    		minDistance = Math.min(minDistance, 
    				doMinDistance(word1.substring(1, word1.length()), word2) + 1);
    	}
    	
    	cache.put(word1 + "-" + word2, minDistance);
    	return minDistance;
    }
    
    public static void main(String[] args) {
    	minDistance("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdef", "bcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefg");
    }
}
