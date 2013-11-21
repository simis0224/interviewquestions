package Recursive;


import java.util.ArrayList;
import java.util.Arrays;
/**
	Given a set of distinct integers, S, return all possible subsets.
	
	Note:
	
	Elements in a subset must be in non-descending order.
	The solution set must not contain duplicate subsets.
	For example,
	If S = [1,2,3], a solution is:
	
	[
	  [3],
	  [1],
	  [2],
	  [1,2,3],
	  [1,3],
	  [2,3],
	  [1,2],
	  []
	]
 */
public class Subsets {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
    	Arrays.sort(S);
    	
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
    	
    	subsets(S, 0, result, results);
    	
    	return results;
        
    }
    
    public void subsets(int[] S, int index, ArrayList<Integer> result, ArrayList<ArrayList<Integer>> results) {
    	if(index == S.length) {
    		ArrayList<Integer> a = new ArrayList<Integer>(result);
    		results.add(a);
    		return;
    	}
    	
    	int size = result.size();
    	result.add(S[index]);
    	subsets(S, index + 1, result, results);
    	result.remove(size);
    	
    	subsets(S, index + 1, result, results);
    }
}
