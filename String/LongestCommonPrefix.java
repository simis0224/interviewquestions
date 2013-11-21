package String;
/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 */

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) {
        	return "";
        }
        
        String s = strs[0];
        for(int i = 1; i < strs.length; i++) {
        	if(strs[i].length() < s.length()) {
        		s = s.substring(0, strs[i].length());
        	}
        	for(int j = 0; j < s.length(); j++) {
        		if(s.charAt(j) != strs[i].charAt(j)) {
        			s = s.substring(0, j);
        			break;
        		}
        	}
        }
        return s;
    }
}
