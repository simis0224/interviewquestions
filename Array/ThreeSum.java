package Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
	Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
	Find all unique triplets in the array which gives the sum of zero.
	
	Note:
	
	Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ? b ? c)
	The solution set must not contain duplicate triplets.
	    For example, given array S = {-1 0 1 2 -1 -4},
	
	    A solution set is:
	    (-1, 0, 1)
	    (-1, -1, 2)
 */

public class ThreeSum {
    public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
    	
    	ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
    	
    	Arrays.sort(num);
    	
    	for(int i = 0; i < num.length - 2; i++) {
    		// skip same number
    		if(i > 0 && num[i] == num[i-1]) {
    			continue;
    		}
    		int j = i + 1;
    		int k = num.length - 1;
    		while(j < k) {
    			if(num[j] + num[k] + num[i] == 0) {
    				ArrayList<Integer> result = new ArrayList<Integer>();
    				result.add(num[i]);
    				result.add(num[j]);
    				result.add(num[k]);
    				results.add(result);
    				j = findNextJ(j, num);
    				k = findNextK(k, num);
    			} else if(num[j] + num[k] + num[i] < 0) {
    				j = findNextJ(j, num);
    			} else {
    				k = findNextK(k, num);
    			}
    		}
    		
    	}
        return results;
    }
    
    public static int findNextJ(int j, int[] num){
		while(true) {
			j++;
			if(j >= num.length || num[j] != num[j-1]) {
				break;
			}
		}
		return j;
    }
    
    public static int findNextK(int k, int[] num){
		while(true) {
			k--;
			if(k < 0 || num[k] != num[k+1]) {
				break;
			}
		}
		return k;
    }
    
    
    public static void main(String [] args) {
    	threeSum(new int[]{-1,0,1,2,-1,-4});
    }
}
