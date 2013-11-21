package Array;

/**
	Follow up for "Search in Rotated Sorted Array":
	What if duplicates are allowed?
	
	Would this affect the run-time complexity? How and why?
	
	Write a function to determine if a given target is in the array.
 */
public class SearchinRotatedSortedArrayII {
    public boolean search(int[] A, int target) {
        return search(A, target, 0, A.length - 1);
    }
    
    
    public static boolean search(int[] A, int target, int start, int end) {
    	if(start > end) {
    		return false;
    	}
    	
    	int mid = (start + end) / 2;
    	
    	if(A[mid] == target) {
    		return true;
    		// if A[start] == A[end], need to search both half
    	} else if(A[start] == A[end]) {
    		return search(A, target, mid + 1, end) || search(A, target, start, mid - 1);
    	} else if(A[start] < A[end]) {
    		if(A[mid] > target) {
    			return search(A, target, start, mid - 1);
    		} else {
    			return search(A, target, mid + 1, end);
    		}
    	} else {
    		// don't forget <=. case 3, 1, 1, target = 3
    		if(A[mid] <= A[end]) {
    			if(target > A[mid] && target <= A[end]) {
    				return search(A, target, mid + 1, end);
    			} else {
    				return search(A, target, start, mid - 1);
    			}
    		} else {
    			// don't forget to make sure target is b/w A[mid] and A[start]
    			if(target < A[mid] && target >= A[start]) {
    				return search(A, target, start, mid - 1);
    			} else {
    				return search(A, target, mid + 1, end);
    			}
    		}
    	}
    }
    
    public static void main(String[] args) {
    	search(new int[]{3, 1, 1}, 3, 0, 2);
    }
}
