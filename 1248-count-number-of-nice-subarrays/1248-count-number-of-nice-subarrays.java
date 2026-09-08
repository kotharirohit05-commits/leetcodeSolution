class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        for(int i = 0; i < nums.length; i++){
            if(nums[i] % 2 == 0){
                nums[i] = 0;
            }else{
                nums[i] = 1;
            }
        }
        return helper(nums, k) - helper(nums, k - 1);
    }
    private int helper(int[] nums, int k){
        int count = 0;
        int l = 0;
        int sum = 0;
        if(k < 0) return 0;
        for(int r = 0; r < nums.length; r++){
            sum += nums[r];
            while(sum > k){
                sum -= nums[l];
                l++;
            }
            count = count + (r - l + 1);
        }
        return count;
    }
}