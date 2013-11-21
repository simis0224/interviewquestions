package Array;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one 
 * share of the stock), design an algorithm to find the maximum profit.
 */
public class BestTimeToBuyStock {
	
	public int maxProfit(int[] prices) {
		if(prices == null || prices.length <= 1) {
			return 0;
		}
		
		int[] lowPriceLeftToRight = new int[prices.length];
		lowPriceLeftToRight[0] = prices[0];
		for(int i = 1; i < prices.length; i++) {
			lowPriceLeftToRight[i] = Math.min(lowPriceLeftToRight[i - 1], prices[i]);
		}
		
		int[] highPriceRightToLeft = new int[prices.length];
		highPriceRightToLeft[prices.length - 1] = prices[prices.length - 1];
		for(int i = prices.length - 2; i >= 0 ; i--) {
			highPriceRightToLeft[i] = Math.max(highPriceRightToLeft[i + 1], prices[i]);
		}
		
		int maxProfit = 0;
		for(int i = 0; i < prices.length; i++) {
			maxProfit = Math.max(maxProfit, highPriceRightToLeft[i] - lowPriceLeftToRight[i]);
		}
		
		return maxProfit;
	}
}
