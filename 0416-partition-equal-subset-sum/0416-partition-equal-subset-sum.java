class Solution {

    private boolean helper(int idx, int[] nums, int req, Boolean[][] dp){
        
        if(req == 0){
            return true;
        }

        if(idx == nums.length){
            return false;
        }

        if(dp[idx][req] != null){
            return dp[idx][req];
        }
        boolean pick = false;
        if (nums[idx] <= req) {
            pick = helper(idx + 1, nums, req - nums[idx], dp);
        }
        
        boolean notpick = helper(idx + 1 , nums, req, dp);

        return dp[idx][req] = pick || notpick;
        

    }

    public boolean canPartition(int[] nums) {
        int req = 0;
        for(int x : nums){
            req += x;
        }

        Boolean[][] dp = new Boolean[nums.length][req + 1];
        
        if(req % 2 != 0) return false;
        
        return helper(0, nums, req / 2, dp);

    }
}