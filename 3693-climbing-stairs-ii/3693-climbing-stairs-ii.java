import java.util.Arrays;

class Solution {
    public int climbStairs(int n, int[] costs) {
        // dp[i] stores the minimum cost to reach step i
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // Starting at step 0 has 0 cost
        
        for (int i = 1; i <= n; i++) {
            // Jump of 1 step from (i - 1) -> i
            if (i - 1 >= 0 && dp[i - 1] != Integer.MAX_VALUE) {
                dp[i] = Math.min(dp[i], dp[i - 1] + costs[i - 1] + 1); // 1^2 = 1
            }
            // Jump of 2 steps from (i - 2) -> i
            if (i - 2 >= 0 && dp[i - 2] != Integer.MAX_VALUE) {
                dp[i] = Math.min(dp[i], dp[i - 2] + costs[i - 1] + 4); // 2^2 = 4
            }
            // Jump of 3 steps from (i - 3) -> i
            if (i - 3 >= 0 && dp[i - 3] != Integer.MAX_VALUE) {
                dp[i] = Math.min(dp[i], dp[i - 3] + costs[i - 1] + 9); // 3^2 = 9
            }
        }
        
        return dp[n];
    }
}
