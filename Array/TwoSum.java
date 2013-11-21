package Array;
import java.util.Arrays;

/**
	Given an array of integers, find two numbers such that they add up to a specific target number.
	
	The function twoSum should return indices of the two numbers such that they add up to the target, 
	where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
	
	You may assume that each input would have exactly one solution.
	
	Input: numbers={2, 7, 11, 15}, target=9
	Output: index1=1, index2=2
 */

public class TwoSum {
	
	    public static int[] twoSum(int[] numbers, int target) {
	        int[] numbersCopy = new int[numbers.length];
	        for(int i = 0; i < numbers.length; i++) {
	            numbersCopy[i] = numbers[i];
	        }
	        Arrays.sort(numbersCopy);
	        
	        int j = 0;
	        int k = numbers.length - 1;
	        while(j < k) {
	        	int sum = numbersCopy[j] + numbersCopy[k];
	        	if(sum == target) {
	        		break;
	        	} else if(sum < target){
	        		j++;
	        	} else {
	        		k--;
	        	}
	        }
	        
	        int index1 = -1;
	        int index2 = -1;
	        if(j < k) {
	        	for(int i = 0; i < numbers.length; i++) {
	        		if(numbers[i] == numbersCopy[j] && index1 == -1) {
	        			index1 = i + 1;
	        		} 
	        		if(numbers[i] == numbersCopy[k] && index2 == -1) {
	        			if(numbersCopy[k] == numbersCopy[j] && index1 - 1 == i) {
	        				continue;
	        			} else {
	        				index2 = i + 1;
	        			}
	        		}
	        	}
	        	
	        	return index1 < index2 ? new int[]{index1, index2} : new int[]{index2, index1};
	        }
	        return null;
	    }
	    
	    public static void main(String [] args) {
	    	int[] index = twoSum(new int[]{2,1,9,4,4,56,90,3}, 8);
	    	System.out.print("1:" + index[0] + " 2:" + index[1]);
	    }
}
