package Array;

/**
	A message containing letters from A-Z is being encoded to numbers using the following mapping:
	
	'A' -> 1
	'B' -> 2
	...
	'Z' -> 26
	Given an encoded message containing digits, determine the total number of ways to decode it.
	
	For example,
	Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
	
	The number of ways decoding "12" is 2.
**/
public class DecodedWays {
	/* Recursive way
	public static char[] mapping = new char[]{
			'A','B','C','D','E','F','G','H','I','J',
			'K','L','M','N','O','P','Q','R','S','T',
			'U','V','W','X','Y','Z'};
	
    public static int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	ArrayList<String> results = new ArrayList<String>();
    	numDecodings(s, "", results);
        return results.size();
    }
    
    public static void numDecodings(String s, String result, ArrayList<String> results) {
    	if(s.length() == 0) {
    		if(result.length() > 0) {
    			results.add(new String(result));
    		}
    		return;
    	}
    	
    	if(s.length() >=2) {
    		int code = Integer.valueOf(s.substring(0, 2));
    		if(code >= 10 && code <= mapping.length) {
    			numDecodings(
    				s.substring(2),
    				result + mapping[code - 1],
    				results);
    		}
    	} 

		int code1 = Integer.valueOf(s.substring(0, 1));
		if(code1 > 0) {
			numDecodings(
    				s.substring(1),
    				result + mapping[code1 - 1],
    				results);
		}
    } */
	
	public static int numDecodings(String s) {
		int[] ways = new int[s.length()];
		
		if(s.length() == 0) {
			return 0;
		}

		for(int i = s.length() - 1; i >= 0; i--) {
			// pay attention to the '0' case
			if(i == s.length() - 1) {
				ways[i] = s.charAt(i) == '0' ? 0 : 1;
			} else {
				if(s.charAt(i) != '0') {
					int code2 = Integer.valueOf(s.substring(i, i + 2));
					int ways2char = 0;
					if(i + 2 > s.length() - 1) {
						ways2char = 1;
					} else {
						ways2char = ways[i+2];
					}
					ways[i] = ways[i+1] + (code2 >= 10 && code2 <= 26 ? 0 : ways2char);
				} else {
					ways[i] = 0;
				}
			}
		}
		
        return ways[0];
    }
    
    public static void main(String [] args) {
    	numDecodings("10");
    }
}
