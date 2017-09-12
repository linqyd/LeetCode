class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;
        int[] result = new int[prices.length];
        // max is max value of result array
        int max = 0;
        // basecase
        result[0] = 0;
        
        // sell at exactlly ith day
        for(int i = 1; i < prices.length; i++)
        {
            result[i] = Math.max(0, result[i-1] + (prices[i] - prices[i-1]));
            max = Math.max(result[i],max);
        }
        
        return max;
    }
}