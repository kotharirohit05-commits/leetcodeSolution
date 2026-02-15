class Solution {
    public int subarraySum(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for(int i = 1 ; i < prefix.length ; i++){
            prefix[i] = prefix[i-1] + nums[i];
        }
        int sum = 0;
        for(int i = 0 ; i < nums.length ; i++){
            int start = Math.max( 0 , i - nums[i]);
            if(start == 0){
                sum += prefix[i];
            }else{
                for(int j = start ; j <= i ; j++){
                    sum += nums[j];
                }
            }
        }
        return sum;
    }
}