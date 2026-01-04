class Solution {
    public int pivotIndex(int[] nums) {
        int[] ls = new int[nums.length];
        int[] rs = new int[nums.length];
        ls[0] = nums[0];
    for(int i  = 1 ; i < nums.length ; i++){
        ls[i] = ls[i-1] + nums[i];
    }
    rs[nums.length - 1] = nums[nums.length - 1];
    for(int i = nums.length - 2 ; i >= 0 ; i--){
        rs[i] = rs[i+1] + nums[i];
    }
    int idx = 0;
    for(int i = 0; i < nums.length ; i++){
        int left = (i == 0)? 0 : ls[i-1];
        int right = (i == nums.length-1)? 0 : rs[i+1];
        if(left == right){
            return i;
        }
    }
    return -1;

    }
}