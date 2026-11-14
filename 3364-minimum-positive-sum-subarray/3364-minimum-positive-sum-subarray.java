class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int minSum = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            int currentSum = 0;
            // Optimization: stop j early if the subarray exceeds maximum length r
            for (int j = i; j < n && j - i + 1 <= r; j++) {
                currentSum += nums.get(j);
                int length = j - i + 1;
                
                if (length >= l && currentSum > 0) {
                    minSum = Math.min(minSum, currentSum);
                }
            }
        }
        
        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }
}
