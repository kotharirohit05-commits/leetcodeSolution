class Solution {

    private int helper(int[] stoneValue , int i, int[] dp){

        int n = stoneValue.length;
        if(i >= n) return 0;
        int res = Integer.MIN_VALUE;

        if(dp[i] != 0) return dp[i];

        res =  stoneValue[i] - helper(stoneValue, i + 1, dp);
        if(i + 1 < n ){
            res = Math.max(res , stoneValue[i] + stoneValue[i+1] - helper(stoneValue, i + 2, dp));
        }
        if(i + 2< n){
            res = Math.max(res, stoneValue[i] + stoneValue[i+ 1] + stoneValue[i + 2] - helper(stoneValue , i + 3, dp) );
        }
        return dp[i] = res;
    }

    public String stoneGameIII(int[] stoneValue) {
        
        int n = stoneValue.length;
        int[] dp = new int[n];
        int diff = helper(stoneValue, 0, dp);

        if(diff > 0){
            return "Alice";
        }else if ( diff < 0){
            return "Bob";
        }else{
            return "Tie";
        }

    }
}