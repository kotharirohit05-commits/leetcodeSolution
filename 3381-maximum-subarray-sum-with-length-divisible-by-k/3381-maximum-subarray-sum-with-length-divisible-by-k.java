class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] prefix = new long[n + 1];

       
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        long ans = Long.MIN_VALUE;
        long[] minPrefix = new long[k];
        Arrays.fill(minPrefix, Long.MAX_VALUE);

        
        for (int i = 0; i <= n; i++) {
            int mod = i % k;

            
            if (minPrefix[mod] != Long.MAX_VALUE) {
                ans = Math.max(ans, prefix[i] - minPrefix[mod]);
            }

            
            minPrefix[mod] = Math.min(minPrefix[mod], prefix[i]);
        }

        return ans;
    }
}
