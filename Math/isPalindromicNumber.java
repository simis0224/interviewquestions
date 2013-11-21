package Math;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * @author qlu
 *
 */
public class isPalindromicNumber {
    public static boolean isPalindrome(int x) {
        if(x < 0) {
        	return false;
        }
        
        int reverse = 0;
        int m = x;
        while(m > 0) {
        	reverse *= 10;
        	reverse += m%10;
        	m /= 10;
        }
        
        return reverse == x;
    }
    
    public static void main(String [] args) {
    	isPalindrome(1);
    }
}
