package besttime;

public class SellAndBuyIII {
	public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
		// This solution is out of time limited.
        if (prices.length <= 1)
            return 0;
        int maxProfit = 0;
        int pre = 0;
        for (int i = 0; i < prices.length; i++) {
        	if (prices[i] == pre) {
        		continue;
        	}
        	pre = prices[i];
            int profit = maxProfit(prices, 0, i) + maxProfit(prices, i, prices.length);
            maxProfit = maxProfit > profit ? maxProfit : profit;
        }
        return maxProfit;
    }
    
    public int maxProfit(int[] prices, int start, int end) {
        if (start == end)
            return 0;
        int min = prices[start];
        int profit = 0;
        for (int i = start; i < end; i++) {
            if (prices[i] >= min) {
                profit = profit > prices[i] - min ? profit : prices[i] - min;
            } else {
                min = prices[i];
            }
        }
        return profit;
    }
    
}
