package String;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
	Given a string, find the length of the longest substring without repeating characters. 
	For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
	which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */

public class LongestNonRepeatingString {
	
    public int lengthOfLongestSubstring2(String s) {
    	if(s == null || s.length() == 0) {
    		return 0;
    	}
    	
    	Set<Character> hasChar = new HashSet<Character>();
    	int beginIndex = 0;
    	int max = 0;
    	for(int i = 0; i < s.length(); i++) {
    		// make sure the set has non-repeated char
    		if(hasChar.contains(s.charAt(i))) {
    			for(int j = beginIndex; j < i; j++) {
    				hasChar.remove(s.charAt(j));
    				if(s.charAt(j) == s.charAt(i)) {
    					beginIndex = j + 1;
    					break;
    				}
    			}
    		}
    		hasChar.add(s.charAt(i));
    		max = Math.max(max, hasChar.size());
    	}
    	
    	return max;
    }
	
	
    public int lengthOfLongestSubstring(String s) {
    	return getLongestSubstring(s, s.length() - 1).maxLength;
    }
    
    public static ReturnResult getLongestSubstring(String s) {
    	return getLongestSubstring(s, s.length() - 1);
    }
    
    public static ReturnResult getLongestSubstring(String s, int lastIndex) {
    	
    	if(lastIndex == 0 || s.length() == 0) {
    		ReturnResult rr = new ReturnResult();
    		if(s.length() > 0) {
    			rr.visited.put(new Character(s.charAt(lastIndex)), lastIndex);
        		rr.startIndex = 0;
        		rr.endIndex = 0;
        		rr.maxLength = 1;
    		} else {
    			rr.maxLength = 0;
    		}
    		return rr;
    	}
    	
    	ReturnResult t = getLongestSubstring(s, lastIndex - 1);
    	int curLength;
    	Integer charIndex = t.visited.get(new Character(s.charAt(lastIndex)));
//    	System.out.println("charIndex:" + charIndex);
//    	System.out.println("visited:" + t.visited);
    	if(charIndex != null) {
    		if(charIndex < t.startIndex) {
    			curLength = lastIndex - t.startIndex + 1;
    		} else {
    			curLength = lastIndex - charIndex;
    			t.startIndex = charIndex + 1;
    		}
    	    for(int i = t.startIndex; i <= charIndex; i++)
    	    	t.visited.remove(s.charAt(i));
    	} else {
    		curLength = lastIndex - t.startIndex + 1;
    	}
    	t.visited.put(new Character(s.charAt(lastIndex)), lastIndex);
    	t.endIndex = lastIndex;
    	
    	if(curLength > t.maxLength) {
    		//System.out.println("maxLength:" + curLength);
    		t.maxLength = curLength;
    	}
    	return t;
    }
    
    public static class ReturnResult {
    	int maxLength;
    	Map<Character, Integer> visited;
    	//String longestString;
    	int startIndex;
    	int endIndex;
    	public ReturnResult() {
    		maxLength = 0;
    		visited = new HashMap<Character, Integer>();
    		startIndex = -1;
    		endIndex = -1;
    	}
    }
    
    public static void main(String [] args) {
    	ReturnResult t = getLongestSubstring("inprobabilitytheoryandstatisticsamedianisdescribedasthenumericvalueseparating");
    	System.out.println(t.maxLength);
    	System.out.println(t.visited);
//    	System.out.println(t.longestString);
    }
//    public int lengthOfLongestSubstring(String s) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//        Map<Character, Integer> usedChar = new HashMap<Character, Integer>();
//        int[] maxLength = new int[s.length()];
//        int[] lastPresence = new int[s.length()];
//        int max = 0;
//        for(int i = 0; i < s.length(); i++) {
//        	if(usedChar.containsKey(s.charAt(i))) {
//        		if(usedChar.get(s.charAt(i-1)) < usedChar.get(s.charAt(i))) {
//        			int curLength = i - usedChar.get(s.charAt(i));
//        			maxLength[i] = curLength;
//        		} else if(usedChar.get(s.charAt(i-1)) > usedChar.get(s.charAt(i))){
//        			maxLength[i] = maxLength[i - 1] + 1;
//        		} else {
//        			maxLength[i] = 1;
//        		}
//        		
//        	} else {
//        		if(i == 0) {
//        			maxLength[i] = 1;
//        		} else {
//        			maxLength[i] = maxLength[i-1] + 1;
//        		}
//        		lastPresence[i] = -1;
//
//        	}
//        	
//    		if(maxLength[i] > max) {
//    			max = maxLength[i];
//    		}
//        	
//        	usedChar.put(s.charAt(i), i);
//        }
//        return max;
//    }
}
