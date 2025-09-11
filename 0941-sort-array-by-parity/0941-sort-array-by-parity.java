class Solution {
    public int[] sortArrayByParity(int[] nums) {
        for(int i = 0 ; i < nums.length -1 ; i++){
            for(int j = i+1 ; j < nums.length ; j++){
                if(nums[j] % 2==0){
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }        
        }
        
        }
        return nums;
    }
}