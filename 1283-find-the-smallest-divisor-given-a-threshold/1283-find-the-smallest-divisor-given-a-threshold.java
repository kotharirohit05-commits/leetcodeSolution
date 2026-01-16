class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        for(int i = 0 ; i < nums.length ; i++){
            high = Math.max(high , nums[i]);
        }
        
        if(nums.length == threshold) return high;
        
        while(low < high){
            int sum = 0;
            int mid = low + (high - low) / 2;
            for(int i = 0; i < nums.length ; i++){
                sum += ((nums[i] + mid - 1) / mid);
            }
            if(sum <= threshold){
                high = mid ;
            }
            else{
                low = mid + 1;
            }
        }
        return low;

    }
}