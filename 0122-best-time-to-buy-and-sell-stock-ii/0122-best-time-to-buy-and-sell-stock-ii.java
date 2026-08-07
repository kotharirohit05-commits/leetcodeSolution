class Solution {

    private int helper(int idx , int buy, int[] prices, int[][] dp){

        int n = prices.length;
        int profit = 0;
        
        if(idx == n) return 0;
        if(dp[idx][buy] != -1) return dp[idx][buy];

        if(buy == 1){
            profit = Math.max(-prices[idx] + helper(idx + 1, 0, prices,dp) , 
                            0 + helper(idx + 1, 1, prices,dp));
        }else{
            profit = Math.max(prices[idx] + helper(idx + 1, 1, prices,dp) ,
                                0 + helper(idx + 1, 0, prices,dp));
        }

        dp[idx][buy] = profit;

        return dp[idx][buy];

    }

    public int maxProfit(int[] prices) {

        int n = prices.length;
        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return helper(0, 1, prices, dp);

    }
}