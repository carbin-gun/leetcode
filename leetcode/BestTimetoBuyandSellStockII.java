/**
 * Best Time to Buy and Sell Stock II
 * 
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete as many
 * transactions as you like (ie, buy one and sell one share of the stock
 * multiple times). However, you may not engage in multiple transactions at the
 * same time (ie, you must sell the stock before you buy again).
 * http://discuss.leetcode.com/questions/286/best-time-to-buy-and-sell-stock-ii
 */

/*
 * The solution is quite easy, only to add all changing values where i > i -1;
 */
public class BestTimetoBuyandSellStockII {
	public int maxProfit(int[] prices) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int ret = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1]) {
				ret += prices[i] - prices[i - 1];
			}
		}
		return ret;
	}
}
