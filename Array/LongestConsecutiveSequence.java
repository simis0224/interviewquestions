package Array;
import java.util.HashMap;

/**
	Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
	
	For example,
	Given [100, 4, 200, 1, 3, 2],
	The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
	
	Your algorithm should run in O(n) complexity.
 */
public class LongestConsecutiveSequence {
	
	
    public int longestConsecutive(int[] num) {
        // Start typing your Java solution below
    	if(num.length == 0) {
    		return 0;
    	}
    	
    	// map saves <integer, the range this integer can reach>, we only care about the pair whose integer is on the boundary of a range.
    	// if integer is the lower bound, upper bound = integer + range; 
    	// if integer is the upper bound, lower bound = integer - range;
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	int maxLength = 0;
    	for(int i = 0 ; i < num.length; i++) {
    		if(map.containsKey(num[i])) {
    			continue;
    		}
    		map.put(num[i], 0);
    		
    		int upper;
    		int lower;
    		int len = 0;
    		if(map.containsKey(num[i] - 1)) {
    			upper = num[i];
    			lower = num[i] - 1 - map.get(num[i] - 1);
    			len = upper - lower;
    			map.put(upper, len);
    			map.put(lower, len);
    		}
    		if(map.containsKey(num[i] + 1)) {
    			upper = num[i] + 1 + map.get(num[i] + 1);
    			lower = num[i] - map.get(num[i]);
    			len = upper - lower;
    			map.put(upper, len);
    			map.put(lower, len);
    		}
    		maxLength = Math.max(maxLength, len);
    	}
    	
    	return maxLength + 1;
    }
    
    
}
