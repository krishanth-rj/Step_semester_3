package arrays.class_problems;

public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int lowestPrice = prices[0];
        int maximumProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - lowestPrice;
            if (profit > maximumProfit) maximumProfit = profit;
            if (prices[i] < lowestPrice) lowestPrice = prices[i];
        }
        return maximumProfit;
    }
}
