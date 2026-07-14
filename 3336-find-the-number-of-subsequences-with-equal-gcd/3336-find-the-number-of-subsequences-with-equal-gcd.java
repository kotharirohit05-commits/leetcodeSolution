class Solution {

    int mod = 1_000_000_007;
    Integer[][][] dp;

    public int subsequencePairCount(int[] nums) {
        dp = new Integer[nums.length][201][201];
        return solve(0, 0, 0, nums);
    }

    private int solve(int idx, int gcd1, int gcd2, int[] nums) {

        if (idx == nums.length) {
            if (gcd1 == gcd2 && gcd1 != 0) {
                return 1;
            }
            return 0;
        }

        if (dp[idx][gcd1][gcd2] != null) {
            return dp[idx][gcd1][gcd2];
        }

        long ans = 0;

       
        ans += solve(idx + 1, gcd1, gcd2, nums);

        
        ans += solve(idx + 1, gcd(gcd1, nums[idx]), gcd2, nums);

        
        ans += solve(idx + 1, gcd1, gcd(gcd2, nums[idx]), nums);

        ans %= mod;

        return dp[idx][gcd1][gcd2] = (int) ans;
    }

    private int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
}