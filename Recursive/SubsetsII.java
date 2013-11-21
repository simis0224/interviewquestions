package Recursive;


import java.util.ArrayList;
import java.util.Arrays;

/**
	Given a collection of integers that might contain duplicates, S, return all possible subsets.
	
	Note:
	
	Elements in a subset must be in non-descending order.
	The solution set must not contain duplicate subsets.
	For example,
	If S = [1,2,2], a solution is:
	
	[
	  [2],
	  [1],
	  [1,2,2],
	  [2,2],
	  [1,2],
	  []
	]
 */
public class SubsetsII {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
    	Arrays.sort(num);
    	subsetsWithDup(num, 0, false, result, results);
        return results;
    }
    
    public void subsetsWithDup(int[] num, int index, boolean lastElemPicked, ArrayList<Integer> result, ArrayList<ArrayList<Integer>> results) {
        if(index == num.length) {
        	ArrayList<Integer> a = new ArrayList<Integer>(result);
        	results.add(a);
        	return;
        }
        
        if(index == 0 || num[index] != num[index - 1] || (lastElemPicked && num[index] == num[index - 1])) {
	        int size = result.size();
	        result.add(num[index]);
	        subsetsWithDup(num, index + 1, true, result, results);
	        result.remove(size);
        }
        
        subsetsWithDup(num, index + 1, false, result, results);
    }
}
