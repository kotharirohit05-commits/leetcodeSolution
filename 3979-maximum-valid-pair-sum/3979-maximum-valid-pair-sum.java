class Solution {
    public int maxValidPairSum(int[] nums, int k) {
        int max = 0;
        int n = nums.length;
        int[] ps = new int[n];
        ps[0] = nums[0];
        for(int i = 1; i < n; i++){
            ps[i] = Math.max(ps[i-1], nums[i]);
        }
        int sum =0;
        for(int r = k; r < n; r++){
            sum = Math.max(nums[r] + ps[r - k] , sum);
        }
        return sum;
    }
}