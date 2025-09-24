class Solution {
    public int maxProfit(int[] prices) {
        int lastLowPrice = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(profit, prices[i] - lastLowPrice);
            lastLowPrice = Math.min(prices[i], lastLowPrice);
        }
        return profit;
    }
}