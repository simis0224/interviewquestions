package Recursive;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
	Given a collection of numbers that might contain duplicates, return all possible unique permutations.
	
	For example,
	[1,1,2] have the following unique permutations:
	[1,1,2], [1,2,1], and [2,1,1].
 */

public class PermutationII {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
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
    	
    	Set<Integer> used = new HashSet<Integer>();
    	for(int i = 0; i < num.length; i++) {
    		if(visited[i] == 0 && !used.contains(num[i])) {
    			result.add(num[i]);
    			visited[i] = 1;
    			permute(num, visited, result, results);
    			result.remove(result.size() - 1);
    			visited[i] = 0;
    			used.add(num[i]);
    		}
    	}
    }
}
