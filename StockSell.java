class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1)
            return 0;
        int[] diff = new int[prices.length -1];
        for(int i = 0; i < diff.length; i++)
            diff[i] = prices[i+1] - prices[i];
        
        int currProfit = 0, maxProfit = 0;
        for(int num : diff)
        {
            currProfit += num;
            maxProfit = Math.max(currProfit, maxProfit);
            currProfit = Math.max(0, currProfit);
        }
        
        return maxProfit;
    }
}