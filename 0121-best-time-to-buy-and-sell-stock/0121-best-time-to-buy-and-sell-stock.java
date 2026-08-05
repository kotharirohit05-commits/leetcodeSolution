class Solution {
    public int maxProfit(int[] prices) {
        
        int min = Integer.MAX_VALUE;
        int max = 0;

        for(int i = 0; i < prices.length; i++){
            int cost = prices[i];
            min = Math.min(min, cost);
            max = Math.max(cost - min , max);


        }
        return max;
        
    }
}