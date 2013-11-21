package Recursive;
/**
	Given a string S and a string T, count the number of distinct subsequences of T in S.
	
	A subsequence of a string is a new string which is formed from the original string by 
	deleting some (can be none) of the characters without disturbing the relative positions 
	of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
	
	Here is an example:
	S = "rabbbit", T = "rabbit"
	
	Return 3.
 */
public class DistinctSequence {
    public static int numDistinct(String S, String T) {
    	if(S.length() == 0) {
    		return 0;
    	}
    	
    	int m = S.length() + 1;
    	int n = T.length() + 1;
    	
    	//dp[i][j] means s.subString(0, i) - T.substring(0, j) common string
    	int[][] dp = new int[m][n];
    	
    	for(int i = 0; i < m; i++) {
    		dp[i][0] = 1;
    	}
    	
    	for(int i = 1; i < m; i++) {
    		for(int j = 1; j < n; j++) {
    			if(S.charAt(i - 1) == T.charAt(j - 1)) {
    				dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
    			} else {
    				dp[i][j] = dp[i - 1][j];
    			}
    		}
    	}
    	
    	
        return dp[m - 1][n - 1];
    }
    
    public static void main(String[] args) {
    	numDistinct("rabbbit", "rabbit");
    }
}
