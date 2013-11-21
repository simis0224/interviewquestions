package Array;


import java.util.ArrayList;

/**
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4]
*/

public class SearchForRange {
	
	public static int[] searchRange(int[] A, int target) {
		int left = searchBoundLeft(A, target, 0, A.length - 1);
		int right = searchBoundRight(A, target, 0, A.length - 1);
		return new int[]{left, right};
	}
	
	public static int searchBoundLeft(int[] A, int target, int start, int end) {
		if(start > end || target < A[start] ) {
			return -1;
		}
		
		if(target == A[start]) {
			return start;
		}
		
		int mid = (start + end) / 2;
		if(A[mid] > target) {
			return searchBoundLeft(A, target, start, mid - 1);
		} else if(A[mid] < target) {
			return searchBoundLeft(A, target, mid + 1, end);
		} else {
			if(mid - 1 >= start && A[mid - 1] == target) {
				return searchBoundLeft(A, target, start, mid - 1);
			} else {
				return searchBoundLeft(A, target, start + 1, mid);
			}
		}
	}
	
	public static int searchBoundRight(int[] A, int target, int start, int end) {
		if( start > end || target > A[end]) {
			return -1;
		}
		
		if(target == A[end]) {
			return end;
		}
		
		int mid = (start + end) / 2;
		if(A[mid] > target) {
			return searchBoundRight(A, target, start, mid - 1);
		} else if(A[mid] < target) {
			return searchBoundRight(A, target, mid + 1, end);
		} else {
			if(mid + 1 <= end && A[mid + 1] == target) {
				return searchBoundRight(A, target, mid + 1, end);
			} else {
				return searchBoundRight(A, target, mid, end - 1);
			}
		}
	}
	
	public static void main(String[] args) {
		searchRange(new int[]{1, 2, 3}, 2);
	//	searchRange(new int[]{1}, 0);
	//	searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
	}
//	public static class ElemInfo {
//		int val;
//		int startIndex;
//		int endIndex;
//		ElemInfo(int val, int start, int end) {
//			this.val = val;
//			this.startIndex = start;
//			this.endIndex = end;
//		}
//		
//		int[] getRange() {
//			return new int[]{startIndex, endIndex};
//		}
//	}
//    public int[] searchRange(int[] A, int target) {
//    	ArrayList<ElemInfo> array = new ArrayList<ElemInfo>();
//    	int i = 0;
//        while(i < A.length) {
//        	int start = i;
//        	int val = A[i];
//        	while(i < A.length && A[i] == val) {
//        		i++;
//        	}
//        	array.add(new ElemInfo(val, start, i - 1));
//        }
//        
//        ElemInfo result = doSearchRange(array, target, 0, array.size() - 1);
//        if(result == null) {
//        	return new int[]{-1, -1};
//        } else {
//        	return result.getRange();
//        }
//    }
//    
//    public ElemInfo doSearchRange(ArrayList<ElemInfo> array, int target, int start, int end) {
//    	if(start > end) {
//    		return null;
//    	}
//    	
//    	int mid = (start + end) / 2;
//    	if(array.get(mid).val == target) {
//    		return array.get(mid);
//    	} else if(array.get(mid).val > target) {
//    		return doSearchRange(array, target, start, mid - 1);
//    	} else {
//    		return doSearchRange(array, target, mid + 1, end);
//    	}
//    }
}
