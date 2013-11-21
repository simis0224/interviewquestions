package Recursive;



import java.util.ArrayList;
import java.util.Arrays;

/**
	Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
	
	The same repeated number may be chosen from C unlimited number of times.
	
	Note:
	
	All numbers (including target) will be positive integers.
	Elements in a combination (a1, a2, � , ak) must be in non-descending order. (ie, a1 ? a2 ? � ? ak).
	The solution set must not contain duplicate combinations.
	For example, given candidate set 2,3,6,7 and target 7, 
	A solution set is: 
	[7] 
	[2, 2, 3] 
**/
public class CombinationSum {
	
	static ArrayList<ArrayList<Integer>> results;
	
    public static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	results = new ArrayList<ArrayList<Integer>>();
    	Arrays.sort(candidates);
    	combinationSum(candidates, target, 0, 0, new ArrayList<Integer>());
    	
    	return results;
        
    }
    
    public static void combinationSum(int[] candidates, int target, int curIndex, int curSum, ArrayList<Integer> pickedElem) {
    	if(curSum == target) {
    		results.add(pickedElem);
    		return;
    	}
    	if(curIndex >= candidates.length) {
    		return;
    	}
    	if(curSum > target) {
    		return;
    	}
    	
    	int tmpSum = curSum;
    	while(tmpSum <= target) {
    		// tmpSum == curSum means first element is not picked up
    		if(tmpSum > curSum) {
    			pickedElem.add(candidates[curIndex]);
    		}
			combinationSum(candidates, target, curIndex + 1, tmpSum, new ArrayList<Integer>(pickedElem));
			tmpSum += candidates[curIndex];
    	}
    }
    
    public static void main(String[] args) {
    	combinationSum(new int[] {1, 2}, 2);
    }
}
