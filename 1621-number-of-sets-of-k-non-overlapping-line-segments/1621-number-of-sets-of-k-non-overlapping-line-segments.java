class Solution {
    public int numberOfSets(int n, int k) {
        int MOD = 1_000_000_007;
        int targetN = n + k - 1;
        int targetK = 2 * k;
        
        // If it's impossible to choose 2k points out of targetN elements
        if (targetK > targetN) {
            return 0;
        }
        
        // Space-optimized Pascal's triangle row
        int[] dp = new int[targetK + 1];
        dp[0] = 1;
        
        // Compute combinations iteratively
        for (int i = 1; i <= targetN; i++) {
            for (int j = Math.min(i, targetK); j > 0; j--) {
                dp[j] = (dp[j] + dp[j - 1]) % MOD;
            }
        }
        
        return dp[targetK];
    }
}
