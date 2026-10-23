class Solution {
    public int sortPermutation(int[] nums) {
        
        int num = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i){
                num = nums[i];
                break;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i){
                num = nums[i] & num;
            }
        }

        return num;

    }
}