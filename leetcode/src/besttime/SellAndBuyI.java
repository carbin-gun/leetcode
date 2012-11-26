package besttime;

public class SellAndBuyI {
	public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (prices.length <= 1) {
            return 0;
        }
        int min = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >= min) {
                profit = profit > prices[i] - min ? profit : prices[i] - min;
            } else {
                min = prices[i];
            }
        }
        
        return profit;
    }
}
