package Recursive;
/**
	Given an array of non-negative integers, you are initially positioned at the first index of the array.
	
	Each element in the array represents your maximum jump length at that position.
	
	Determine if you are able to reach the last index.
	
	For example:
	A = [2,3,1,1,4], return true.
	
	A = [3,2,1,0,4], return false.
 */
public class JumpGame {
    public static boolean canJump(int[] A) {
        return canJump(0, A[0], A);
    }
    
    public static boolean canJump(int curIndex, int maxReachIndex, int[] A) {
        
        if(maxReachIndex >= A.length - 1) {
    		return true;
    	}
    	
    	int nextMaxReachIndex = curIndex;
    	for(int i = curIndex; i < A.length && i <=  maxReachIndex; i++) {
    		if(A[i] + i > nextMaxReachIndex) {
    			nextMaxReachIndex = A[i] + i;
    		}
    	}
    	
    	if(nextMaxReachIndex > maxReachIndex) {
    		return canJump(maxReachIndex + 1, nextMaxReachIndex, A);
    	} else {
    		return false;
    	}
    }
    
    public static void main(String [] args) {
    	canJump(new int[]{1,2,0,1});
    }
}
