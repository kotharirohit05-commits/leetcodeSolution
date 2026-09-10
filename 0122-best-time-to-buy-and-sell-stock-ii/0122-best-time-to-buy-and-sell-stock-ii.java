class Solution {

    private int helper(int idx, int buy, int[] prices, int[][] dp){

        if(idx == prices.length) return 0;

        if(dp[idx][buy] != -1) return dp[idx][buy];

        int profit = 0;

        if(buy == 1){
            profit = Math.max(-prices[idx] + helper( idx + 1, 0, prices, dp), helper(idx + 1, 1, prices, dp));
        }else{
            profit = Math.max(prices[idx] + helper(idx , 1, prices, dp), helper(idx + 1, 0, prices, dp));
        }


        return dp[idx][buy] = profit;

    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] x : dp){
            Arrays.fill(x, -1);
        }
        return helper(0, 1, prices, dp);
    }
}