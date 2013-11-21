package needVerification;

public class LongestIncreasingArray {

	public static int[] longestIncreasingArray(int[] numbers) {
		
		if(numbers == null || numbers.length == 0) {
			return new int[] {-1, -1};
		}
		
		if(numbers.length == 1) {
			return new int[] {0, 0};
		}
		
		int beginIndex = 0;
		int lastBegin = 0;
		int maxCount = 1;
		int count = 1;
		for(int i = 1; i < numbers.length; i++) {
			if(numbers[i - 1] < numbers[i]) {
				count++;
				if(count > maxCount) {
					maxCount = count;
					beginIndex = lastBegin;
				}
			} else {
				lastBegin = i;
				count = 1;
			}
		}
		return new int[] {beginIndex, maxCount};
	}
	
	public static void main(String[] agrs) {
		longestIncreasingArray(new int[]{2,-3,-1,0,40});
		longestIncreasingArray(new int[]{2,3,4,0,40});
		longestIncreasingArray(new int[]{-5,-7,10,100,0,-10});
		
	}
	
}
