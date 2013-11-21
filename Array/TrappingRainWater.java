package Array;
/**
	Given n non-negative integers representing an elevation map where the width of each bar is 1, 
	compute how much water it is able to trap after raining.
	
	For example, 
	Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
	
	The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 
	6 units of rain water (blue section) are being trapped.
 */
public class TrappingRainWater {
	//Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
    public int trap(int[] A) {
        if(A.length == 0) {
            return 0;
        }
    	
    	int sum = 0;
    	int[] leftHighest = new int[A.length];
    	
    	int tmp = A[0];
    	for(int i = 0; i < A.length; i++) {
    		if(A[i] > tmp) {
    			tmp = A[i];
    		} 
    		leftHighest[i] = tmp;
    	}
    	
    	tmp = A[A.length - 1];
    	for(int i = A.length - 1; i >=0; i--) {
    		if(tmp < A[i]) {
    			tmp = A[i];
    		}
    		sum += Math.min(tmp, leftHighest[i]) - A[i];
    	}
        
        return sum;
    }
}
