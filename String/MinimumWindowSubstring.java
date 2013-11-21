package String;
import java.util.HashMap;

/**
	Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
	
	For example,
	S = "ADOBECODEBANC"
	T = "ABC"
	
	Minimum window is "BANC".
	
	Note:
	If there is no such window in S that covers all characters in T, return the emtpy string "".
	
	If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class MinimumWindowSubstring {
    public static String minWindow(String S, String T) {
    	// T.length > S.length, there cannot be any match
    	if(T.length() > S.length()) {
    		return "";
    	}
    	
    	// construct needChar
    	HashMap<Character, Integer> needChar = new HashMap<Character,Integer>();
    	for(int i = 0; i < T.length(); i++) {
    		if(!needChar.containsKey(T.charAt(i))) {
    			needChar.put(T.charAt(i), 1);
    		} else {
    			needChar.put(T.charAt(i), needChar.get(T.charAt(i)) + 1);
    		}
    	}
    	
    	int beginIndex = 0;
    	int endIndex = 0;
    	int count = 0;
    	String minString = S;
    	HashMap<Character, Integer> hasChar = new HashMap<Character, Integer>();
    	while(endIndex < S.length()) {
    		// if S[endIndex] is not in T, doesn't care. move on.
    		if(!needChar.containsKey(S.charAt(endIndex))) {
    			endIndex++;
    			continue;
    		}
    		
    		// construct hasChar
    		// keep count to check if reach a match
    		if(!hasChar.containsKey(S.charAt(endIndex))){
    			hasChar.put(S.charAt(endIndex), 1);
    			count++;
    		} else {
    			int hasCharNum = hasChar.get(S.charAt(endIndex));
    			hasChar.put(S.charAt(endIndex), hasCharNum + 1);
    			if(hasCharNum + 1 <= needChar.get(S.charAt(endIndex))) {
    				count++;
    			}
    		}
    		
    		// if already has a match, move beginIndex forward if:
    		// 1. needChar < hasChar
    		// or 2. S[beginIndex] is not in T. Doesn't care.
    		if(count == T.length()) {
    			while(beginIndex <= endIndex) {
    				if(needChar.containsKey(S.charAt(beginIndex))) {
	    				if(hasChar.get(S.charAt(beginIndex)) > needChar.get(S.charAt(beginIndex))) {
	    					hasChar.put(S.charAt(beginIndex), hasChar.get(S.charAt(beginIndex)) - 1);
	    					beginIndex++;
	    				} else {
	    					break;
	    				}
    				} else {
    					beginIndex++;
    				}
    			}
    			// new min length, update minString
    			int newLength = endIndex - beginIndex + 1;
    			if(newLength < minString.length()) {
    				minString = S.substring(beginIndex, endIndex + 1);
    			}
    		}
    		endIndex++;
    	}
    	
    	// return minString only if there is a match
        return count == T.length() ? minString : "";
    }
    
    public static void main(String [] args) {
    	minWindow("ab", "b");
    }
}
