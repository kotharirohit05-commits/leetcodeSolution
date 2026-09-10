class Solution {

    private boolean helper(int[] nums, int idx, int target, Boolean[][] dp){

        if(target == 0) return true;

        if(idx == 0) return false;

        if(dp[idx][target] != null) return dp[idx][target];

        boolean notpick = helper(nums, idx - 1, target, dp);
        boolean pick = false;
        if(nums[idx] <= target){
            pick = helper(nums, idx - 1, target - nums[idx], dp);
        }

        return dp[idx][target] = notpick || pick;


    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int x : nums){
            sum += x;
        }
        int target = sum / 2;
        if( sum % 2 != 0) return false;
        Boolean[][] dp = new Boolean[nums.length][target + 1];
        return helper(nums, nums.length - 1, target, dp);
    }
}