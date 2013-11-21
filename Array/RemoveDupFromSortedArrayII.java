package Array;
/**
	Follow up for "Remove Duplicates":
	What if duplicates are allowed at most twice?
	
	For example,
	Given sorted array A = [1,1,1,2,2,3],
	
	Your function should return length = 5, and A is now [1,1,2,2,3].
 */

public class RemoveDupFromSortedArrayII {
    public static int removeDuplicates(int[] A) {
	    int i = 0;
	    int p = 0;
	    while(i < A.length) {
	    	int tmpCount = 1;
	    	while(i > 0 && i < A.length && A[i] == A[i - 1]) {
	    		if(tmpCount < 2) {
	    			// don't forget to copy A[p] = A[i]
	    			A[p] = A[i];
	    			p++;
	    		}
	    		i++;
	    		tmpCount++;
	    	}
	    	// don't forget i < A.length
	    	if(i < A.length) {
		    	A[p] = A[i];
		    	i++;
		    	p++;
	    	}
	    }
    	return p;
    }
    
    
    public static void main(String[] args) {
    	removeDuplicates(new int[]{1,1,1});
    }
    
}
