class Solution {
    public int findDuplicate(int[] nums) {
        int ans = 0;
        for(int i = 0 ; i < nums.length ; i++){
            int idx = Math.abs(nums[i]) - 1;
            if(nums[idx] < 0) ans = Math.abs(nums[i]);
            else nums[idx] = - nums[idx];
        }
        return ans;
    }
}