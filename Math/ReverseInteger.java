package Math;

/**
	Reverse digits of an integer.
	
	Example1: x = 123, return 321
	Example2: x = -123, return -321
 */
public class ReverseInteger {
    public int reverse(int x) {
        if(x == 0) {
        	return x;
        }
        
        boolean isNegative = false;
        if(x < 0) {
        	isNegative = true;
        	x = -x;
        }
        
        int reverse = 0;
        while(x > 0) {
        	int k = x % 10;
        	reverse *= 10;
        	reverse += k;
        	x /= 10;
        }
        
        return isNegative ? -1 * reverse : reverse;
    }

}
