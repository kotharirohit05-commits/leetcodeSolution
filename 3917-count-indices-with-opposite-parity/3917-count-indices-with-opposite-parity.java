class Solution {
    public int[] countOppositeParity(int[] nums) {
        int count = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] % 2 != 0){
                    for(int j = i ; j < nums.length ; j++){
                        if(nums[j] % 2 == 0){
                            count++;
                        }
                    }
                }else{
                    for(int j = i ; j < nums.length ; j++){
                        if(nums[j] % 2 != 0){
                            count++;
                        }
                    }
                }
            nums[i] = count;
            count = 0;
            
        }
        return nums;
    }
}