package Array;

public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        int p = m - 1;
        int q = n - 1;
        int s = m + n - 1;
        while(p >= 0 && q >= 0) {
        	if(A[p] > B[q]) {
        		A[s] = A[p];
        		p--;
        	} else {
        		A[s] = B[q];
        		q--;
        	}
        	s--;
        }
        
        if(p < 0) {
        	while(q >= 0) {
        		A[s] = B[q];
        		q--;
        		s--;
        	}
        }
    }
}
