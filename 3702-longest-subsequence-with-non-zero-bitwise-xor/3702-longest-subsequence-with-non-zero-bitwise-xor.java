class Solution {
    public int longestSubsequence(int[] nums) {
        Arrays.sort(nums);
        if(nums[0] == 0 && nums[nums.length - 1] == 0){
            return 0;
        }
        int ans = 0;
        for(int x : nums){
            ans = ans ^ x;
        }
        if(ans != 0) return nums.length;
        if(ans == 0) return nums.length - 1;
        return 0;
    }
}