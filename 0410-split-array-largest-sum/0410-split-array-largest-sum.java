class Solution {

    private int helper(int[] nums, int mid){

        int count = 1;
        long subcount = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] + subcount <= mid ){
                subcount += nums[i];
            }else{
                count++;
                subcount = nums[i];
            }
        }
        return count;

    }

    public int splitArray(int[] nums, int k) {
        int sum = 0;
        int low = 0;
        for(int x : nums){
            low = Math.max(x, low);
            sum += x;
        }
        int high = sum;

        while(low <= high){
            int mid = low + (high - low) / 2;
            int ans = helper(nums, mid);
            if(ans > k){
                low = mid + 1; 
            }else{
                high = mid - 1;
            }
        }

        return low;

    }
}