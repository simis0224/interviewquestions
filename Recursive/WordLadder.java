package Recursive;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/**
	Given two words (start and end), and a dictionary, find the length of shortest transformation 
	sequence from start to end, such that:
	
	Only one letter can be changed at a time
	Each intermediate word must exist in the dictionary
	For example,
	
	Given:
	start = "hit"
	end = "cog"
	dict = ["hot","dot","dog","lot","log"]
	
	As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
	return its length 5.
	
	Note:
	
	Return 0 if there is no such transformation sequence.
	All words have the same length.
	All words contain only lowercase alphabetic characters.
 */

public class WordLadder {
	
	public static class StringInfo {
		String str;
		int distance;
		StringInfo(String str, int distance) {
			this.str = str;
			this.distance = distance;
		}
	}
	
	
	public static int ladderLength(String start, String end, HashSet<String> dict) {
		HashMap<String, Integer> visited = new HashMap<String, Integer>();
		List<StringInfo> lastStringQueue = new ArrayList<StringInfo>();
		
		lastStringQueue.add(new StringInfo(start, 1));
		
		while(!lastStringQueue.isEmpty()) {
			
			StringInfo lastStringInfo = lastStringQueue.remove(0);
			
			char[] lastStrChar = lastStringInfo.str.toCharArray();
			for(int i = 0; i < lastStrChar.length; i++) {
				char tmp = lastStrChar[i];
				for(char j = 'a'; j <= 'z'; j++) {
					if(lastStrChar[i] == j) {
						continue;
					}
					lastStrChar[i] = j;
					String newStart = String.valueOf(lastStrChar);
					if(dict.contains(newStart)) {
						if(!visited.containsKey(newStart) || visited.get(newStart) > lastStringInfo.distance + 1) {
							visited.put(newStart, lastStringInfo.distance + 1);
							lastStringQueue.add(new StringInfo(newStart, lastStringInfo.distance + 1));
						}
					}
				}
				lastStrChar[i] = tmp;
			}
		}
		
		return visited.containsKey(end) ? visited.get(end) : 0;
	}
	
//    public static int ladderLength(String start, String end, HashSet<String> dict) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//    	ladderLength(start, end, dict, new HashSet<String>());
//    	int tmp = min == Integer.MAX_VALUE ? 0 : min;
//    	min = Integer.MAX_VALUE;
//        return tmp;
//    }
//    
//    
//    public static void ladderLength(String start, String end, HashSet<String> dict, HashSet<String> visited) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//        if(start.equals(end)) {
//        	if(min > visited.size() + 2) {
//        		min = visited.size() + 2;
//        	}
//        	return;
//        }
//        
//        char[] startChar = start.toCharArray();
//        for(int i = 0; i < start.length(); i++) {
//        	for(char j = 'a'; j <= 'z'; j++) {
//        		if(startChar[i] == j) {
//        			continue;
//        		}
//        		
//        		char tmp = startChar[i];
//        		startChar[i] = j;
//        		String newStart = String.valueOf(startChar);
//        		if(dict.contains(newStart) && !visited.contains(newStart)) {
//        			visited.add(newStart);
//        			ladderLength(newStart, end, dict, visited);
//        			visited.remove(newStart);
//        		}
//        		startChar[i] = tmp;
//        	}
//        }
//    }
    
    
    public static void main(String [] args) {
    	HashSet<String> dict = new HashSet<String>();
    	dict.add("a");
    	dict.add("b");
    	dict.add("c");
    	ladderLength("a", "b", dict);
    }
}
