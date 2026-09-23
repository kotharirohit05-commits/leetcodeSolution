class Solution {
    public int minOperations(int[] nums, int x) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        // Target sum for the middle contiguous subarray
        int target = totalSum - x;
        
        // If target is 0, we must remove all elements to reach x
        if (target == 0) return nums.length;
        // If target is negative, x is larger than the entire array sum
        if (target < 0) return -1;
        
        int maxLength = -1;
        int currentSum = 0;
        int left = 0;
        
        // Sliding window to find the longest middle subarray that equals target
        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];
            
            // Shrink the window from the left if the sum exceeds the target
            while (currentSum > target && left <= right) {
                currentSum -= nums[left];
                left++;
            }
            
            // If the exact target is hit, track the maximum window size
            if (currentSum == target) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }
        
        // Remaining operations = Total array length - Longest middle subarray length
        return maxLength == -1 ? -1 : nums.length - maxLength;
    }
}
