package Array;
import java.util.ArrayList;
/**
	Given numRows, generate the first numRows of Pascal's triangle.
	
	For example, given numRows = 5,
	Return
	
	[
	     [1],
	    [1,1],
	   [1,2,1],
	  [1,3,3,1],
	 [1,4,6,4,1]
	]
 */
public class PascalTriangle {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
    	ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
    	
    	
    	for(int i = 0; i < numRows; i++) {
    		ArrayList<Integer> result = new ArrayList<Integer>();
    		if(i == 0) {
    			result.add(1);
    		} else {
    			for(int j = 0; j <= i; j++) {
    				if(j == 0 || j == i) {
    					result.add(1);
    				} else {
    					result.add(results.get(i - 1).get(j) + results.get(i - 1).get(j - 1));
    				}
    			}
    		}
    		results.add(result);
    	}
    	
    	return results;
    }
}
