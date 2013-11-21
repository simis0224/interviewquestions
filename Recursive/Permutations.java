package Recursive;
import java.util.ArrayList;

/**
	Given a collection of numbers, return all possible permutations.
	
	For example,
	[1,2,3] have the following permutations:
	[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */

public class Permutations {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
    	int[] visited = new int[num.length];
    	for(int i = 0; i < num.length; i++) {
    		visited[i] = 0;
    	}
    	
        permute(num, visited, result, results);
        return results;
    }
    
    public void permute(int[] num, int[] visited, ArrayList<Integer> result, ArrayList<ArrayList<Integer>> results) {
    	if(result.size() == num.length) {
    		results.add(new ArrayList<Integer>(result));
    		return;
    	} 
    	
    	for(int i = 0; i < num.length; i++) {
    		if(visited[i] == 0) {
    			result.add(num[i]);
    			visited[i] = 1;
    			permute(num, visited, result, results);
    			result.remove(result.size() - 1);
    			visited[i] = 0;
    		}
    	}
    }
}
