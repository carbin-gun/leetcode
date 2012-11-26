package besttime;

public class SellAndBuyII {
	public int maxProfit(int[] prices) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (prices.length <= 1)
			return 0;
		int dailyProfit[] = new int[prices.length - 1];
		for (int i = 1; i < prices.length; i++) {
			dailyProfit[i - 1] = prices[i] - prices[i - 1];
		}
		int profit = 0;
		for (int i = 0; i < dailyProfit.length; i++) {
			if (dailyProfit[i] > 0)
				profit += dailyProfit[i];
		}
		return profit;
	}
}
