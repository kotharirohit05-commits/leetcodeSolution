class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return isMax(nums , goal) - isMax(nums , goal - 1);
    }
    private int isMax(int[] nums , int goal){
        int l = 0;
        int count  = 0;
        int sum = 0;

        if(goal < 0) return 0;
        for(int r = 0 ; r < nums.length ; r++){
            sum += nums[r];
            while(sum > goal){
                sum -= nums[l];
                l++;
            }
            count = count +  ((r - l) + 1);
        }
        return count;
    }
}