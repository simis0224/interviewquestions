package Recursive;
/**
	Given an array of non-negative integers, you are initially positioned at the first index of the array.
	
	Each element in the array represents your maximum jump length at that position.
	
	Your goal is to reach the last index in the minimum number of jumps.
	
	For example:
	Given array A = [2,3,1,1,4]
	
	The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 */
public class JumpGameII {
    public static int jump(int[] A) {
    	if(A.length == 1) {
    		return 0;
    	}
        return canJump(0, A[0], A, 1);
    }
    
    public static int canJump(int curIndex, int maxReachIndex, int[] A, int numJump) {
    	
        if(maxReachIndex >= A.length - 1) {
    		return numJump;
    	} 
    	
    	int nextMaxReachIndex = curIndex;
    	for(int i = curIndex; i < A.length && i <=  maxReachIndex; i++) {
    		if(A[i] + i > nextMaxReachIndex) {
    			nextMaxReachIndex = A[i] + i;
    		}
    	}
    	
    	if(nextMaxReachIndex > maxReachIndex) {
    		return canJump(maxReachIndex + 1, nextMaxReachIndex, A, numJump + 1);
    	} else {
    		return -1;
    	}
    }
    
    public static void main(String [] args) {
    	jump(new int[]{5,9,3,2,1,0,2,3,3,1,0,0});
    }
}
