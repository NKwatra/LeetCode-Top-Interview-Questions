class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;
        int maxProfit = 0, currProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1])
                currProfit += prices[i + 1] - prices[i];
            else {
                maxProfit += currProfit;
                currProfit = 0;
            }
        }

        return maxProfit + currProfit;
    }
}