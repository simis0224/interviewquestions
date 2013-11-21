package Array;

/**
	Given an array with n objects colored red, white or blue, 
	sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
	
	Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
	
	Note:
	You are not suppose to use the library's sort function for this problem.
	
	Follow up:
	A rather straight forward solution is a two-pass algorithm using counting sort.
	First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, 
	then 1's and followed by 2's.
	
	Could you come up with an one-pass algorithm using only constant space?
 */
public class SortColors {
    public static void sortColors(int[] A) {
        int q = A.length - 1;
        int p = 0;
        
        // if there is swap happen, don't increase i.
        for(int i = 0; i < A.length;) {
        	if(A[i] == 0) {
        		if(i > p) {
        			swap(A, i, p);
        			p++;
        		} else {
        			i++;
        		}
        	} else if(A[i] == 2) {
        		if(i < q) {
        			swap(A, i, q);
        			q--;
        		} else {
        			i++;
        		}
        	} else {
        		i++;
        	}
        }
    }
    
    public static void swap(int[]A, int i, int j) {
    	int tmp = A[i];
    	A[i] = A[j];
    	A[j] = tmp;
    }
    
    public static void main(String [] args) {
    	sortColors(new int[]{1, 2, 0});
    }
}
