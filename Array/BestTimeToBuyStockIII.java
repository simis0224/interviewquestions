package Array;
/**
	Say you have an array for which the ith element is the price of a given stock on day i.
	
	Design an algorithm to find the maximum profit. You may complete at most two transactions.
	
	Note:
	You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class BestTimeToBuyStockIII {
    public static int maxProfit(int[] prices) {
    	if(prices.length <= 1) {
    		return 0;
    	}
    	
        int min = prices[0];
        int[] t1 = new int[prices.length];
        t1[0] = 0;
        for(int i = 1; i < prices.length; i++) {
        	t1[i] = Math.max(t1[i - 1], prices[i] - min);
        	min = Math.min(min, prices[i]);
        }
        
        int max = prices[prices.length - 1];
        int[] t2 = new int[prices.length];
        t2[prices.length - 1] = 0;
        for(int j = prices.length - 2; j >= 0; j--) {
        	t2[j] = Math.max(max - prices[j], t2[j + 1]);
        	max = Math.max(max, prices[j]);
        }
        
		// dont forget the one transaction case
		int maxProfit = t1[prices.length - 1];
        for(int i = 1; i < prices.length; i++) {
        		// check the profit if 1st transaction is b/w [0, i - 1], 2nd transaction is b/w [i, last day]
        	maxProfit = Math.max(maxProfit, t1[i - 1] + t2[i]);

        }
        
        return maxProfit;
    }
    
    public static void main(String[] args) {
    	maxProfit(new int[]{2,1,2,1,0,0,1});
    }
}
