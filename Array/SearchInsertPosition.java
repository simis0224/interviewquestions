package Array;

/**
	Given a sorted array and a target value, return the index if the target is found. 
	If not, return the index where it would be if it were inserted in order.
	
	You may assume no duplicates in the array.
	
	Here are few examples.
	[1,3,5,6], 5 → 2
	[1,3,5,6], 2 → 1
	[1,3,5,6], 7 → 4
	[1,3,5,6], 0 → 0
 */
public class SearchInsertPosition {
    public int searchInsert(int[] A, int target) {
        return doSearchInsert(A, target, 0, A.length - 1);
    }
    
    public int doSearchInsert(int[] A, int target, int start, int end) {
    	// good end case!!
    	if(target < A[start]) {
    		return start;
    	}
    	
    	if(target > A[end]) {
    		return end + 1;
    	}
    	
        int mid = (start + end) / 2;
        if(A[mid] == target) {
        	return mid;
        } else if(A[mid] > target) {
        	return doSearchInsert(A, target, start, mid - 1);
        } else {
        	return doSearchInsert(A, target, mid + 1, end);
        }
    }
}
