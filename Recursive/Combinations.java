package Recursive;
import java.util.ArrayList;

/**
	Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
	
	For example,
	If n = 4 and k = 2, a solution is:
	
	[
	  [2,4],
	  [3,4],
	  [2,3],
	  [1,2],
	  [1,3],
	  [1,4],
	]
**/

public class Combinations {
    public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
    	combine(n, k, 1, result, results);
    	
    	return results;
    }
    
    public static void combine(int n, int k, int i, ArrayList<Integer> result, ArrayList<ArrayList<Integer>> results) {
    	if(result.size() == k) {
    		results.add(new ArrayList<Integer>(result));
    		return;
    	}
    	
    	if(i == n + 1) {
    		return;
    	}
    	
    	// don't use n;
    	combine(n, k, i + 1, result, results);
    	
    	result.add(i);
    	combine(n, k, i + 1, result, results);
    	result.remove(result.size() - 1);
    }
    
    public static void main(String [] args) {
    	combine(2, 1);
    }
}
