package Array;
/**
	Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
	
	If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
	
	The replacement must be in-place, do not allocate extra memory.
	
	Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
	1,2,3 → 1,3,2
	3,2,1 → 1,2,3
	1,1,5 → 1,5,1
 */

public class NextPermutation {
    public static void nextPermutation(int[] num) {
    	int k = -1;
    	// find first digit i from right to left which digit i < digit i+1
        for(int i = num.length - 1; i > 0 ; i--) {
        	if(num[i] > num[i - 1]) {
        		k = i - 1;
        		break;
        	}
        }
        
        // swap first digit from right that is great than num[k] and swap them
        if( k >= 0) {
	        for(int i = num.length - 1; i >= k + 1; i--) {
	        	if(num[i] > num[k]) {
	        		int tmp = num[i];
	        		num[i] = num[k];
	        		num[k] = tmp;
	        		break;
	        	}
	        }
        }
	        
        int p = k + 1;
        int q = num.length - 1;
        while(p < q) {
        	int tmp = num[p];
        	num[p] = num[q];
        	num[q] = tmp;
        	p++;
        	q--;
        }
    }
    
    public static void main(String[] arg) {
    	nextPermutation(new int[] {1});
    }
}
