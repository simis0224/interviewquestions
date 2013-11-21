package String;
/**
	 Implement regular expression matching with support for '.' and '*'.
	
	'.' Matches any single character.
	'*' Matches zero or more of the preceding element.
	
	The matching should cover the entire input string (not partial).
	
	The function prototype should be:
	bool isMatch(const char *s, const char *p)
	
	Some examples:
	isMatch("aa","a") ? false
	isMatch("aa","aa") ? true
	isMatch("aaa","aa") ? false
	isMatch("aa", "a*") ? true
	isMatch("aa", ".*") ? true
	isMatch("ab", ".*") ? true
	isMatch("aab", "c*a*b") ? true
 */
public class ExpressionMatch {
	
	public static boolean isMatch(String s, String p) {
		
		// empty string and empty pattern
		if(s.length() == 0 && p.length() == 0) {
			return true;
		}
		
		// 1. to match first character without considering '*' in the second char of the pattern p. 
		//    for example, s=abc, p=abc*, continue match s="bc", p="bc*"
		//                 s=abc, p=.bc, continue match s="bc", p="bc"
		// 2. to match first character of pattern p whose length is 1.
		//    for example, s=a, p=a, continue match s="", p=""
		if(s.length() > 0 && ((p.length() >= 2 && p.charAt(1) != '*') || (p.length() <= 1 && p.length() >0)) ) {
			// match only if first char is the same or first char is '.'
			if(p.charAt(0) == s.charAt(0) || p.charAt(0) == '.') { 
				return isMatch(s.substring(1), p.substring(1));
			}
		}
		
		// match the case if second char of pattern is '*'
		if(p.length() >=2 && p.charAt(1) == '*') {
			// 1. s is empty, then first two chars in p should match. Then continue to match the rest of p.
			// for example, s="", p="c*a*", continue match s="", p="a*"
			if(s.length() == 0) {
				return isMatch(s, p.substring(2));
			}
			// 2. if p has '.*', need to try every possibility of s.
			// for example, s=abcde, p=".*", continue match s="abcde"/"bcde"/"cde"/"de"/"e"/"", p="";
			if(p.charAt(0) == '.') {
				for(int i = 0; i <= s.length(); i++) {
					if(isMatch(s.substring(i), p.substring(2))) {
						return true;
					} 
				}
			} else {
				// 3. if first char of s and p match, continue match the rest of s
				// for example, s=aaaabc, p=a*, continue match s="aaabc", p="a*"
				if(s.charAt(0) == p.charAt(0)) {
					if(isMatch(s.substring(1), p)) {
						return true;
					}
				} 
				// 4. if first char of s doesn't match with p, continue match the rest of p
				// for example, s="abcde", p="b*", continue match s="abcde", p=""
			    if(isMatch(s, p.substring(2))) {
						return true;
				}
			}
		}
		
		return false;
	}
    
    public static void main(String [] args) {
    	boolean isMatch = isMatch("", "c*c*");
    	System.out.println(isMatch);
    }
//    public static boolean isMatch(String s, String p) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//    	if(s.isEmpty() && p.isEmpty()) {
//    		return true;
//    	}
//    	
//    	if(s.isEmpty() || p.isEmpty()) {
//    		return false;
//    	}
//    	
//    	int curP = 0;
//    	int curS = 0;
//    	char repeatChar = 0;
//    	
//    	boolean isMatch = true;
//    	while(curP < p.length() && curS < s.length() && isMatch) {
//    		if(p.charAt(curP) == '*') {
//    			if(p.charAt(curP - 1) != '.') {
//    				repeatChar = p.charAt(curP - 1);
//    			}
//    			for(; curS < s.length(); curS++) {
//    				if(s.charAt(curS) != repeatChar) {
//    					break;
//    				}
//    			}
//    			curP++;
//    		} else if (p.charAt(curP) == '.') {
//    			curP++;
//    			repeatChar = s.charAt(curS);
//    		} else {
//    			if(p.charAt(curP) != s.charAt(curS)) {
//    				isMatch = false;
//    			} else {
//    				curP++;
//    				curS++;
//    			}
//    		}
//    	}
//    	
//    	return isMatch && curP == p.length() && curS == s.length();
//    }

}
