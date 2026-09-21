class Solution {
    public long[] resultArray(int[] nums, int k) {
        int n = nums.length;
        long[] ans = new long[k];
        
        // Total possible non-empty subarrays: n * (n + 1) / 2
        long totalSubarrays = (long) n * (n + 1) / 2;
        
        // dp[r] stores the count of subarrays ending at the previous position 
        // that have a product modulo k equal to r.
        long[] dp = new long[k];
        
        for (int num : nums) {
            int rem = num % k;
            
            // If the element is a multiple of k, it breaks the product chain for non-zero remainders
            if (rem == 0) {
                // Reset DP table for the next valid segment
                for (int r = 0; r < k; r++) {
                    dp[r] = 0;
                }
                continue;
            }
            
            long[] nextDp = new long[k];
            
            // 1. Start a brand new subarray at the current element
            nextDp[rem]++;
            
            // 2. Extend existing subarrays that ended at the previous element
            for (int r = 1; r < k; r++) {
                if (dp[r] > 0) {
                    int nextRem = (r * rem) % k;
                    nextDp[nextRem] += dp[r];
                }
            }
            
            // 3. Accumulate valid counts into the final answer for remainders > 0
            for (int r = 1; r < k; r++) {
                ans[r] += nextDp[r];
            }
            
            // Move to the next iteration
            dp = nextDp;
        }
        
        // 4. Any subarray containing at least one element divisible by k will yield 0 mod k.
        // Simply subtract all strictly positive remainder counts from the total count.
        long nonZeroCounts = 0;
        for (int r = 1; r < k; r++) {
            nonZeroCounts += ans[r];
        }
        ans[0] = totalSubarrays - nonZeroCounts;
        
        return ans;
    }
}
