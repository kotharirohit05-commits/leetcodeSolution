class Solution {
    public int absDifference(int[] nums, int k) {
        if(nums.length == 1)
            return 0;
        Arrays.sort(nums);
        int sumfromfront = 0;
        int sumfromback = 0;
        for (int i = 0; i < k; i++) {
            sumfromfront += nums[i];
        }
        for (int i = nums.length - 1; i >= nums.length - k; i--) {
            sumfromback += nums[i];
        }
        return Math.abs(sumfromback - sumfromfront);
    }
}