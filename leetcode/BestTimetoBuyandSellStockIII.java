

/**
 * Best Time to Buy and Sell Stock III
 * 
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most two
 * transactions.
 * 
 * Note: You may not engage in multiple transactions at the same time (ie, you
 * must sell the stock before you buy again).
 * 
 * http://discuss.leetcode.com/questions/287/best-time-to-buy-and-sell-stock-iii
 * 
 */

/*
 * The solution is a dp idea, find a separated day, and count max-one transaction 
 * profit in both side. find the max separated day. By using extra space, we could
 * reduce the run time to o(n). record the max-one transaction profit in two array, 
 * one for left to i, and one for i to right.
 */
public class BestTimetoBuyandSellStockIII {
	public int maxProfit(int[] prices) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (prices.length <= 1) {
			return 0;
		}
		int ret = 0;
		int ps[] = new int[prices.length];
		int min = prices[0];
		for (int i = 1; i < prices.length; i++) {
			min = Math.min(min, prices[i]);
			ps[i] = Math.max(ps[i - 1], prices[i] - min);
		}
		int pe[] = new int[prices.length];
		int max = prices[prices.length - 1];
		for (int i = prices.length - 2; i >= 0; i--) {
			max = Math.max(max, prices[i]);
			pe[i] = Math.max(pe[i + 1], max - prices[i]);
		}
		for (int i = 0; i < prices.length; i++) {
			ret = Math.max(ret, pe[i] + ps[i]);
		}
		return ret;
	}
}
