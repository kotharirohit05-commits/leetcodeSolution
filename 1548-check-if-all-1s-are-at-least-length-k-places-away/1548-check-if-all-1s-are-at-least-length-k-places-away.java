class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int count = k;
        for(int i = 0 ; i < nums.length ;i++){
            if(nums[i] == 0){
                count++;
            }else {
                if(count < k) return false;
                count = 0;
            }
        }

        return true;
    }
}