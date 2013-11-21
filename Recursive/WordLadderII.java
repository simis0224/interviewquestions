package Recursive;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
	Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:
	
	Only one letter can be changed at a time
	Each intermediate word must exist in the dictionary
	For example,
	
	Given:
	start = "hit"
	end = "cog"
	dict = ["hot","dot","dog","lot","log"]
	
	Return
	
	  [
	    ["hit","hot","dot","dog","cog"],
	    ["hit","hot","lot","log","cog"]
	  ]
 */
public class WordLadderII {
	
	static class WordInfo {
		String word;
		ArrayList<String> path;
		WordInfo(String word, ArrayList<String> path) {
			this.word = word;
			this.path = path;
		}
	}
	
    public static ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
        HashMap<String, Integer> visited = new HashMap<String, Integer>();
        ArrayList<WordInfo> queue = new ArrayList<WordInfo>();
        int minDistance = Integer.MAX_VALUE;
        
        ArrayList<String> path = new ArrayList<String>();
        path.add(start);
        queue.add(new WordInfo(start, path));
        visited.put(start, 0);
        while(!queue.isEmpty()) {
        	// don't forget to remove elem from queue
        	WordInfo wordInfo = queue.get(0);
        	queue.remove(0);
        	
        	if(end.equals(wordInfo.word)) {
        		if(minDistance > wordInfo.path.size()) {
        			results.clear();
        			minDistance = wordInfo.path.size();
        		}
        		if(wordInfo.path.size() == minDistance) {
        			results.add(wordInfo.path);
        		}
         	} else {
         		String curWord = wordInfo.word;
         		for(int i = 0; i < curWord.length(); i++) {
         			for(char c = 'a'; c <= 'z'; c++) {
         				if(curWord.charAt(i) == c) {
         					continue;
         				}
         				
         				char[] curWordChars = curWord.toCharArray();
         				curWordChars[i] = c;
         				String newWord = String.copyValueOf(curWordChars);
         				
         				// check dict
         				if(!dict.contains(newWord)) {
         					continue;
         				}
         				
         				
         				if(!visited.containsKey(newWord) || 
         						(visited.containsKey(newWord) && wordInfo.path.size() + 1 <= visited.get(newWord))) {
         					visited.put(newWord, wordInfo.path.size() + 1);
         					path = new ArrayList<String>(wordInfo.path);
         					path.add(newWord);
         					queue.add(new WordInfo(newWord, path));
         				} 
         			}
         		}
         	}
        }
        return results;
    }
    
    public static void main(String[] args) {
    	HashSet<String> dict = new HashSet<String>();
    	dict.add("a");
    	dict.add("b");
    	dict.add("c");
    	findLadders("a", "c", dict);
    }
}
