package Array;
import java.util.ArrayList;
/**
	Given an index k, return the kth row of the Pascal's triangle.
	
	For example, given k = 3,
	Return [1,3,3,1].
	
	Note:
	Could you optimize your algorithm to use only O(k) extra space?
 */
public class PascalTriangleII {

    public static ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        result.add(1);
        
        for(int i = 1; i <= rowIndex; i++) {
        	for(int j = i; j >= 0; j--) {
        		if(j == 0) {
        			result.set(j, 1);
        		} else if(j == i) {
        			result.add(1);
        		} else {
        			result.set(j, result.get(j - 1) + result.get(j));
        		}
        	}
        }
        
        return result;
    }
    
    
    public static void main(String[] args) {
    	getRow(3);
    }
}
