package Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
	Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? 
	Find all unique quadruplets in the array which gives the sum of target.
	
	Note:
	
	Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ? b ? c ? d)
	The solution set must not contain duplicate quadruplets.
	    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
	
	    A solution set is:
	    (-1,  0, 0, 1)
	    (-2, -1, 1, 2)
	    (-2,  0, 0, 2)
 */
public class FourSum {
	static class TwoSumInfo {
		int first;
		int firstIndex;
		int second;
		int secondIndex;
		TwoSumInfo(int first, int second, int firstIndex, int secondIndex) {
			this.first = first;
			this.firstIndex = firstIndex;
			this.second = second;
			this.secondIndex = secondIndex;
		}
	}
	
	static HashSet<String> resultIndex;
	
    public static ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        HashMap<Integer, ArrayList<TwoSumInfo>> twoSums = new HashMap<Integer, ArrayList<TwoSumInfo>>();
        resultIndex = new HashSet<String>();
        
        for(int i = 0; i < num.length; i++) {
        	for(int j = i + 1; j < num.length; j++) {
        		int sum = num[i] + num[j];
        		if(twoSums.containsKey(sum)) {
        			twoSums.get(sum).add(new TwoSumInfo(num[i], num[j], i, j));
        		} else {
        			ArrayList<TwoSumInfo> list = new ArrayList<TwoSumInfo>();
        			list.add(new TwoSumInfo(num[i], num[j], i, j));
        			twoSums.put(sum, new ArrayList<TwoSumInfo>(list));
        		}
        	}
        }
        
        Iterator<Integer> iterator = twoSums.keySet().iterator();
        while(iterator.hasNext()) {
        	int twoSum1 = iterator.next();
        	int twoSum2 = target - twoSum1;
        	if(twoSums.containsKey(twoSum2)) {
        		ArrayList<TwoSumInfo> list1 = twoSums.get(twoSum1);
        		ArrayList<TwoSumInfo> list2 = twoSums.get(twoSum2);
        		
    			for(int i = 0; i < list1.size(); i++) {
    				for(int j = twoSum1 == twoSum2 ? i + 1 : 0; j < list2.size(); j++) {
    					int[] indexes = new int[4];
    					indexes[0]  = list1.get(i).firstIndex;
    					indexes[1]  = list2.get(j).firstIndex;
    					indexes[2]  = list1.get(i).secondIndex;
    					indexes[3]  = list2.get(j).secondIndex;
    					Arrays.sort(indexes);
    					
    					
    					ArrayList<Integer> res = new ArrayList<Integer>();
    					res.add(list1.get(i).first);
    					res.add(list2.get(j).first);
    					res.add(list1.get(i).second);
    					res.add(list2.get(j).second);
    					Collections.sort(res);
    					String indexKey = res.get(0) + "-" + res.get(1) + "-" + res.get(2) + "-" + res.get(3);
    					
    					if(indexes[0] != indexes[1] && indexes[1] != indexes[2] && indexes[2] != indexes[3] && !resultIndex.contains(indexKey)) {
	        				results.add(res);
	        				resultIndex.add(indexKey);
    					}
    				}
    			}
        	} 
        }
        return results;
    }
    
    public static void main(String[] args) {
    	fourSum(new int[]{0,2,-10,-4,1,-7,-4,9,1,-3,-4,-6,-7,-6,-2,7,-5,2}, 0);
    }
}
