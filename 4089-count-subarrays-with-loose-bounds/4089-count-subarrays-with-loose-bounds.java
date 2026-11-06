class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long count = 0;
        int cs = 0;
        int i = 0; 
        while(i < nums.length){
            
            
            if(nums[i] >= minK && nums[i] <= maxK){
                cs++;
                count += cs;
                
            }else{
                cs = 0;
            }
            i++;
        }
        return count;
    }
}