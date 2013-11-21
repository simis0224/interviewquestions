package Array;
/**
	There are two sorted arrays A and B of size m and n respectively. 
	Find the median of the two sorted arrays. The overall run time 
	complexity should be O(log (m+n)).
 */
public class MedianTwoSortedArray {
    public static double findMedianSortedArrays(int a[], int b[]) {
    	boolean isOdd = (a.length + b.length) % 2 == 1 ? true : false; 
    	if(isOdd) {
    		return findKth(a, 0, b, 0, (a.length + b.length + 1)/2);
    	} else {
    		double k1 = findKth(a, 0, b, 0, (a.length + b.length)/2);
    		double k2 = findKth(a, 0, b, 0, (a.length + b.length)/2 + 1);
    		return (k1+k2)/2;
    	}
    }
    
    public static double findKth(int a[], int as, int b[], int bs, int k) {
    	
    	// assume a is smaller
    	if(a.length - as > b.length - bs) {
    		return findKth(b, bs, a, as, k);
    	} 

    	// if a is empty
    	if(a.length - as == 0) {
    		return b[bs + k - 1];
    	}
    	
    	if(k == 1) {
    		return Math.min(a[as], b[bs]);
    	}

    	
    	int pa = Math.min(k/2, a.length - as);
    	int pb = k - pa;
    	
    	if(a[as + pa - 1] < b[bs + pb - 1]) {
    		return findKth(a, as + pa, b, bs, k - pa);
    	} else if(a[as + pa - 1] > b[bs + pb - 1]){
    		return findKth(a, as, b, bs + pb, k - pb);
    	} else {
    		return a[as + pa - 1];
    	}
    }
    
    public static void main(String [] args) {
//    	double k = findMedianSortedArrays(new int[] {}, new int[] {1});
//    	System.out.println(k);
//    	k = findMedianSortedArrays(new int[] {2}, new int[] {});
//    	System.out.println(k);
    	double k = findMedianSortedArrays(new int[] {100000}, new int[] {100001});
    	System.out.println(k);
    }
}
