package Recursive;

import java.util.ArrayList;
import java.util.HashSet;

public class WordLadderIIRecursive {
	
	int minDistance;
	ArrayList<ArrayList<String>> results;
	
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        minDistance = Integer.MAX_VALUE;
        results = new ArrayList<ArrayList<String>>();
        ArrayList<String> path = new ArrayList<String>();
        path.add(start);
    	findLadders(start, end, dict, new HashSet<String>(), path);
    	return results;
    }
    
    public void findLadders(String start, String end, HashSet<String> dict, HashSet<String> visited, ArrayList<String> path) {
    	if(path.size() > minDistance) {
    		return;
    	}
    	
    	if(start.equals(end)) {
    		if(path.size() < minDistance) {
    			results.clear();
    			minDistance = path.size();
    		}
    		if(path.size() == minDistance) {
    			results.add(new ArrayList<String>(path));
    		}
    		return;
    	}
    	
    	for(int i = 0; i < start.length(); i++) {
    		for(char c = 'a'; c <= 'z'; c++) {
    			char[] newStart = start.toCharArray();
    			newStart[i] = c;
    			String newString = String.copyValueOf(newStart);
    			if(dict.contains(newString) && !visited.contains(newString)) {
    				visited.add(newString);
    				path.add(newString);
    				findLadders(newString, end, dict, visited, path);
    				visited.remove(newString);
    				path.remove(path.size() - 1);
    			}
    		}
    	}
    }
}
