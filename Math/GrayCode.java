package Math;


import java.util.ArrayList;
/**
	The gray code is a binary numeral system where two successive values differ in only one bit.
	
	Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
	
	For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
	
	00 - 0
	01 - 1
	11 - 3
	10 - 2
	Note:
	For a given n, a gray code sequence is not uniquely defined.
	
	For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
	
	For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
*/

public class GrayCode {
	
    public ArrayList<Integer> grayCode(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	
    	ArrayList<Integer> results = new ArrayList<Integer>();
    	results.add(0);
    	
    	if(n == 0) {
    		return results;
    	}
    	
    	results.add(1);
    	int k = 2;
    	while(results.size() != Math.pow(2, n)) {
    		int endIndex = results.size() - 1;
    		for(int i = endIndex; i >= 0; i--) {
    			results.add(results.get(i) + k);
    		}
    		k *= 2;
    	}
    	
        return results;
    }
    
}
