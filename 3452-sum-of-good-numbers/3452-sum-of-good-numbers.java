class Solution {
    public int sumOfGoodNumbers(int[] nums, int k) {
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            boolean leftGood = (i - k < 0) || nums[i] > nums[i - k];
            boolean rightGood = (i + k >= nums.length) || nums[i] > nums[i + k];

            if (leftGood && rightGood) {
                sum += nums[i];
            }
        }

        return sum;
    }
}
