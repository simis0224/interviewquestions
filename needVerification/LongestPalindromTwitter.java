package needVerification;

public class LongestPalindromTwitter {
	

	public static boolean isPalindrom(String s) {
	     if(s == null) {
	          return false;
	     }
	     if(s.length() <= 1) {
	          return true;
	     }
	     int p = 0, q = s.length() - 1;
	     while(p <= q) {
	          if(s.charAt(p) != s.charAt(q)) {
	               return false;
	          }
	          p++;
	          q--;
	     }
	     return true;
	}
	
	public static String longestPalindrome(String s) {
		if(s == null || s.length() == 0) {
			return s;
		}
		
		String maxPalindrome = "";
		for(int i = 0; i < s.length(); i++) {
			String palindrome1 = "" + s.charAt(i);
			String palindrome2 = "";
			boolean noMorePalindrome1 = false;
			boolean noMorePalindrome2 = false;
			for(int j = 1; i - j >= 0 && i + j <= s.length(); j++) {
				if(i + j <= s.length() - 1 && !noMorePalindrome1) {
					if(s.charAt(i - j) != s.charAt(i + j)) {
						noMorePalindrome1 = true;
					} else {
						palindrome1 = s.charAt(i - j) + palindrome1 + s.charAt(i + j);
					}
				}
				
				if(!noMorePalindrome2) {
					if(s.charAt(i - j) != s.charAt(i + j - 1) && !noMorePalindrome2) {
						noMorePalindrome2 = true;
					} else {;
						palindrome2 = s.charAt(i - j) + palindrome2 + s.charAt(i + j - 1);
					}
				}
				if(noMorePalindrome1 && noMorePalindrome2) {
					break;
				}
			}
			maxPalindrome = palindrome1.length() > maxPalindrome.length() ? palindrome1 : maxPalindrome;
			maxPalindrome = palindrome2.length() > maxPalindrome.length() ? palindrome2 : maxPalindrome;
		}
		
		return maxPalindrome;
	}
	
	public static void main(String[] args) {
		boolean isPalin1 = isPalindrom("aa");
		boolean isPalin2 = isPalindrom("");
		boolean isPalin3 = isPalindrom("a");
		boolean isPalin4 = isPalindrom("aba");
		boolean isPalin5 = isPalindrom("abba");
		boolean isPalin6 = isPalindrom("acbba");
		boolean isPalin7 = isPalindrom("abbaa");
	}

}
