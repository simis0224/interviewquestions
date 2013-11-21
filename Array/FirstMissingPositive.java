package Array;
/**
	Given an unsorted integer array, find the first missing positive integer.
	
	For example,
	Given [1,2,0] return 3,
	and [3,4,-1,1] return 2.
	
	Your algorithm should run in O(n) time and uses constant space.
 */
public class FirstMissingPositive {
    public static int firstMissingPositive(int[] A) {
    	int i = 0;
        while(i < A.length) {
        	// no swap case
        	if(A[i] == i + 1 || A[i] <=0 || A[i] >= A.length || A[i] == A[A[i] - 1]) {
        		i++;
        		continue;
        	}
        	
        	int tmp = A[i];
        	int targetIndex = A[i] - 1;
        	A[i] = A[targetIndex];
        	A[targetIndex] = tmp;
        }
        
        for(i = 0; i < A.length; i++) {
        	if(A[i] != i+1) {
        		return i+1;
        	}
        }
        // if i reaches the end of A, this means every element in A[] has A[i] == i+1
        return A.length + 1;
    }
    
    public static void main(String [] args) {
    	firstMissingPositive(new int[]{2, 1});
    }
}
