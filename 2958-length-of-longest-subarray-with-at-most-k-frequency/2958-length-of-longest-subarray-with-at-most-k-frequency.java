import java.util.HashMap;

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> frequency = new HashMap<>();
        int left = 0;
        int maxLength = 0;
        
        for (int right = 0; right < nums.length; right++) {
            // Add the current element to the frequency map
            frequency.put(nums[right], frequency.getOrDefault(nums[right], 0) + 1);
            
            // Shrink the window from the left if the current element's frequency exceeds k
            while (frequency.get(nums[right]) > k) {
                frequency.put(nums[left], frequency.get(nums[left]) - 1);
                left++;
            }
            
            // Calculate and update the maximum length of a valid subarray
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}
