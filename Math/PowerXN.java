package Math;
/**
	Implement pow(x, n).
 */

public class PowerXN {
    public double pow(double x, int n) {
        if(n == 0) {
        	return 1;
        } 
        
        if(n == 1) {
        	return x;
        }
        
        double v = pow(x, Math.abs(n/2));
        
        if(n%2 == 0) {
        	v = v*v;
        } else {
        	v = v*v*x;
        }
        
        // don't forget sign
        if(n < 0) {
        	return 1 / v;
        } else {
        	return v;
        }
    }
}
