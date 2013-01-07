/**
 * Best Time to Buy and Sell Stock
 * 
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * If you were only permitted to complete at most one transaction (ie, buy one
 * and sell one share of the stock), design an algorithm to find the maximum
 * profit.
 * 
 * http://discuss.leetcode.com/questions/94/best-time-to-buy-and-sell-stock
 */

/*
 * Keep monitor the cur min value, and record the max profit base on the min value;
 */
public class BestTimetoBuyandSellStock {
	public int maxProfit(int[] prices) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int min = Integer.MAX_VALUE;
		int ret = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < min) {
				min = prices[i];
			} else {
				ret = Math.max(ret, prices[i] - min);
			}
		}
		return ret;
	}
}
