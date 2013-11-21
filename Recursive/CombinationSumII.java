package Recursive;
import java.util.ArrayList;
import java.util.Arrays;
/**
	Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
	
	Each number in C may only be used once in the combination.
	
	Note:
	
	All numbers (including target) will be positive integers.
	Elements in a combination (a1, a2, � , ak) must be in non-descending order. (ie, a1 ? a2 ? � ? ak).
	The solution set must not contain duplicate combinations.
	For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
	A solution set is: 
	[1, 7] 
	[1, 2, 5] 
	[2, 6] 
	[1, 1, 6]
**/
public class CombinationSumII {
	
	ArrayList<ArrayList<Integer>> results;
	
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	results = new ArrayList<ArrayList<Integer>>();
    	Arrays.sort(num);
    	combinationSum(num, target, 0, 0, false, new ArrayList<Integer>());
    	
    	return results;
    }
    
    public void combinationSum(int[] num, int target, int curSum, int curIndex, boolean lastElemPicked, ArrayList<Integer> pickedElem) {
    	if(curSum == target) {
    		results.add(new ArrayList<Integer>(pickedElem));
    		return;
    	}
    	if(curSum > target || curIndex >= num.length) {
    		return;
    	}
    	
    	boolean shouldPick = true;
    	
    	// if element is equal as last element, pick it only if last element is picked
    	// or if last element is not picked, we can pick this element.
    	if(curIndex > 0 && num[curIndex] == num[curIndex - 1] && !lastElemPicked) {
    		shouldPick = false;
    	}
    	
    	if(shouldPick) {
	    	int i = pickedElem.size();
	    	pickedElem.add(num[curIndex]);
	    	combinationSum(num, target, curSum + num[curIndex], curIndex + 1, true, pickedElem);
	    	pickedElem.remove(i);
    	}
    	
    	combinationSum(num, target, curSum, curIndex + 1, false, pickedElem);
    }
}
