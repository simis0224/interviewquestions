package Array;

/**
	You are climbing a stair case. It takes n steps to reach to the top.
	Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 **/
public class ClimbingStairs {
	
	int climbStairs(int n) {
		if(n <= 2) {
			return n;
		}
		
		
		int[] steps = new int[n];
		steps[0] = 1;
		steps[1] = 2;
		
		for(int i = 2; i < n; i++) {
			steps[i] = steps[i - 1] + steps[i - 2];
		}
		
		return steps[n - 1];
	}

}
