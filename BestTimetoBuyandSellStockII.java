class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;
        
        int[] result = new int[prices.length];
        result[0] = 0;
        result[1] = Math.max(prices[1]-prices[0],0);
        int max = Math.max(result[0],result[1]);
        
        for(int i = 2; i < prices.length; i++)
        {
            result[i] = Math.max(result[i-2] + Math.max(0,prices[i]-prices[i-1]), 
                                 Math.max(0, result[i-1] + (prices[i]-prices[i-1])));
            max= Math.max(max,result[i]);
        }
        
        return max;
    }
}