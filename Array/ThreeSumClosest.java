package Array;

import java.util.Arrays;

/**
	Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
	Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */

public class ThreeSumClosest {
    public int threeSumClosest(int[] num, int target) {
    	Arrays.sort(num);
    	int closestSum = 0;
    	int diff = Integer.MAX_VALUE;
        for(int i = 0; i < num.length && diff != 0; i++) {
        	int p = 0;
        	int q = num.length - 1;
        	while(p < q && diff != 0) {
        		if(p == i) {
        			p++;
        			continue;
        		}
        		
        		if(q == i) {
        			q--;
        			continue;
        		}
        		
        		int sum = num[i] + num[p] + num[q];
        		if(Math.abs(sum - target) < diff) {
        			diff = Math.abs(sum - target);
        			closestSum = sum;
        		}
        		if(sum == target) {
        			break;
        		} else if(sum < target) {
        			p++;
        		} else {
        			q--;
        		}
        	}
        }
        return closestSum;
    }
}
