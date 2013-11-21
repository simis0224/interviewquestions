package Array;
/**
	Suppose a sorted array is rotated at some pivot unknown to you beforehand.
	
	(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	
	You are given a target value to search. If found in the array return its index, otherwise return -1.
	
	You may assume no duplicate exists in the array.
 */

public class SearchInRotatedSortedArray {
    public int search(int[] A, int target) {
        return search(A, target, 0, A.length - 1);
    }
    
    public int search(int[] A, int target, int start, int end) {
    	if(start > end) {
    		return -1;
    	}
    	
    	int mid = (start + end) / 2;
    	if(A[mid] == target) {
    		return mid;
    	}
    	// don't forget <=
    	if(A[start] <= A[end]) {
    		if(target < A[mid]) {
    			return search(A, target, start, mid - 1);
    		} else {
    			return search(A, target, mid + 1, end);
    		}
    	} else {
    		// don't forget <= and >=
    		if(A[mid] >= A[start] && A[mid] >= A[end]) {
    			if(A[start] <= target && A[mid] >= target) {
    				return search(A, target, start, mid - 1);
    			} else {
    				return search(A, target, mid + 1, end);
    			}
    		} else {
    			if(A[mid] <= target && A[end] >= target) {
    				return search(A, target, mid + 1, end);
    			} else {
    				return search(A, target, start, mid - 1);
    			}
    		}
    	}
    }
}
