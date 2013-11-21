package Math;
/**
	Implement int sqrt(int x).
	
	Compute and return the square root of x.
 */

public class Sqrt {
    public static int sqrt(int x) {
        if(x == 0) {
        	return 0;
        }
        
        int p = 1;
        int q = x;
        while(p <= q) {
        	int mid = (p + q) / 2;
        	if(mid == x / mid) {
        		return mid;
        	} else if (mid < x / mid) {
        		p = mid + 1;
        	} else {
        		q = mid - 1;
        	}
        }
        // return q instead of p
        return q;
    }
    
    public static void main(String [] args) {
    	sqrt(2147395599);
    }
}
