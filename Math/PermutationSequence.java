package Math;

/**
	The set [1,2,3,É,n] contains a total of n! unique permutations.
	
	By listing and labeling all of the permutations in order,
	We get the following sequence (ie, for n = 3):
	
	"123"
	"132"
	"213"
	"231"
	"312"
	"321"
	Given n and k, return the kth permutation sequence.
	
	Note: Given n will be between 1 and 9 inclusive.
 */
public class PermutationSequence {
	
    public static String getPermutation(int n, int k) {
        int[] num = new int[n]; // save 1, 2, 3, ... , n
        int permNum = 1;  // save n!
        String result = "";
    	for(int i = 0; i < n; i++) {
        	num[i] = i + 1;
        	permNum *= i + 1;
        }
    	
    	k--;
    	
    	for(int i = 0; i < n; i++) {
    		permNum /= n - i;
    		int index = k / permNum; // index = how many (n - 1)!
    		result += num[index];
    		for(int j = index; j < n - 1; j++) {
    			num[j] = num[j + 1];
    		}
    		k = k % permNum;
    	}
    	return result;
    }
    
    public static void main(String[] arg) {
    	getPermutation(1, 1);
    }
	
//	int index;
//	Set<Integer> visited;
//	String result;
//	
//    public String getPermutation(int n, int k) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//        result = null;
//        visited = new HashSet<Integer>();
//        index = 1;
//        doGetPermutation(n, k, "");
//        return result;
//    }
//    
//    public void doGetPermutation(int n, int k, String s) {
//    	if(result != null) {
//    		return;
//    	} 
//    	
//    	if(s.length() == n ) {
//    		if(index == k) {
//    			result = s;
//    		} else {
//    			index ++;
//    		}
//    		return;
//    	}
//    	
//    	for(int i = 1; i <=n; i++) {
//    		if(!visited.contains(i)) {
//    			visited.add(i);
//    			doGetPermutation(n, k, s + "" + i);
//    			visited.remove(i);
//    		}
//    	}
//    }

}
