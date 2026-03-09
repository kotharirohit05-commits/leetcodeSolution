class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int l = 0 ;
        double sum = 0;
        double avg = 0;

            for(int i  = 0 ; i < k ; i++){
                sum += nums[i];
            }
            avg = sum / k;

        for(int r = k  ; r < nums.length ; r++){
            sum += nums[r];
            sum -= nums[l];
            l++;
            avg = Math.max(avg ,sum / k );
        }
        return avg
;
    }
}