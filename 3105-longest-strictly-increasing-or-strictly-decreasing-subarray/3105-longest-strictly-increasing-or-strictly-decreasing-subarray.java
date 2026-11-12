class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int inc = 0;
        int dec = 0;
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[j] > nums[j-1]){
                    inc = Math.max(inc, j - i);
                }else{
                    break;
                }
            }
        }
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[j-1] > nums[j]){
                    dec = Math.max(dec, j - i);
                }else{
                    break;
                }
            }
        }
        return Math.max(inc,dec) + 1;
    }
}