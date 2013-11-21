package Array;

/**
	Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
    n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two 
    lines, which together with x-axis forms a container, such that the container contains the most water.
	
	Note: You may not slant the container.
 */

//Since i is lower than j, 
                //so there will be no jj < j that make the area from i,jj 
                //is greater than area from i,j
                //so the maximum area that can benefit from i is already recorded.
                //thus, we move i forward.
                //因为i是短板，所以如果无论j往前移动到什么位置，都不可能产生比area更大的面积
                //换句话所，i能形成的最大面积已经找到了，所以可以将i向前移。
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	int max = 0;
    	for(int i = 0, j = height.length - 1; i < j; ) {
    		int area = (j - i) * Math.min(height[i], height[j]);
    		if(area > max) {
    			max = area;
    		}
    		if(height[i] < height[j]) {
    			i++;
    		} else {
    			j--;
    		}
    	}
        return max;
    }
}
