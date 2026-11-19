import java.util.Arrays;

class Solution {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        
        // Case 1: Change the two smallest elements (nums[0], nums[1]) to match nums[2]
        int removeTwoSmallest = nums[n - 1] - nums[2];
        
        // Case 2: Change the smallest (nums[0]) and largest (nums[n - 1]) elements
        int removeOneEach = nums[n - 2] - nums[1];
        
        // Case 3: Change the two largest elements (nums[n - 1], nums[n - 2]) to match nums[n - 3]
        int removeTwoLargest = nums[n - 3] - nums[0];
        
        return Math.min(removeTwoSmallest, Math.min(removeOneEach, removeTwoLargest));
    }
}
