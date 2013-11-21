package Recursive;

/**
	Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
	
	You have the following 3 operations permitted on a word:
	
	a) Insert a character
	b) Delete a character
	c) Replace a character
 */
public class EditDistance {
	
	
	public static int minDistance(String word1, String word2) {
		if(word1.length() == 0) {
			return word2.length();
		}
		
		if(word2.length() == 0) {
			return word1.length();
		}
		
		if(word1.equals(word2)) {
			return 0;
		}
		
		
		int[][] distance = new int[word1.length() + 1][word2.length() + 1];
		
		for(int i = 0; i <= word1.length(); i++) {
			distance[i][0] = i;
		}
		
		for(int i = 0; i <= word2.length(); i++) {
			distance[0][i] = i;
		}
		
		// distance[i][j] is the distance to convert word1.substring(0, i) to word2.substring(0, j)
		// for example, word1 = [s1]a, word2=[s2]b, a is the ith char and b is the jth char
		for(int i = 1; i <= word1.length(); i++) {
			for(int j = 1; j <= word2.length(); j++) {
				// if a == b
				if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
					distance[i][j] = distance[i - 1][j - 1];
				} else {
					int minDistance = Integer.MAX_VALUE;
					// replace a to b
					minDistance = distance[i - 1][j - 1] + 1;
					
					// append b to s2
					minDistance = Math.min(minDistance, distance[i - 1][j] + 1);
					
					// remove a from word1
					minDistance = Math.min(minDistance, distance[i][j - 1] + 1);
					
					// don't forget to set it back
					distance[i][j] = minDistance;
				}
			}
		}
		
		return distance[word1.length()][word2.length()];
	}
	
    public static void main(String[] args) {
    	minDistance("a", "b");
    	//minDistance("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdef", "bcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefg");
    }
}
