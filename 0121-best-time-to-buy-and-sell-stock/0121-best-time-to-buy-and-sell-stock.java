class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for(int i = 0; i < prices.length; i++ ){
            int cost = prices[i];
            if(cost < min){
                min = cost;
            }
            else{
                ans = Math.max(ans, cost - min);
            }
            
            
        }
        return ans;
    }
}