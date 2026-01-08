class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return com(nums , upper) - com(nums , lower - 1);
    }
    private long com(int[] nums ,int target){
        int left = 0 ;
        int right = nums.length - 1;
        long count = 0;
        while(left < right){
            long sum = (long) nums[left] + nums[right];
            if(sum <= target){
                count += right - left;
                left++;
            }
            else{
                right--;
            }
        }
        return count;
    }
}