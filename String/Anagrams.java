package String;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of strings, return all groups of strings that are anagrams.
 * Note: All inputs will be in lower-case.
 */
public class Anagrams {
	
	static Map<String, ArrayList<String>> mapping;
	
    public static ArrayList<String> anagrams(String[] strs) {
    	mapping = new HashMap<String, ArrayList<String>>();
    	
        for(int i = 0; i < strs.length; i++) {
        	// we can also consider sort the string and save to map
        	int[] charCount = new int[26];
        	for(int j = 0; j < strs[i].length(); j++) {
        		charCount[strs[i].charAt(j) - 'a']++;
        	}
        	String key = "";
        	for(int j = 0; j < charCount.length; j++) {
        		key += charCount[j] + "-";
        	}
        	if(mapping.containsKey(key)) {
        		mapping.get(key).add(strs[i]);
        	} else {
        		ArrayList<String> result = new ArrayList<String>();
        		result.add(strs[i]);
        		mapping.put(key, result);
        	}
        }
        
        int max = 1;
        ArrayList<String> result = new ArrayList<String>();
        for(ArrayList<String> list : mapping.values()) {
        	if(list.size() > max ) {
        		result.addAll(list);
        	}
        }
        return result;
    }
    
    public static void main(String[] args) {
    	anagrams(new String[] {"", ""});
    }
}
