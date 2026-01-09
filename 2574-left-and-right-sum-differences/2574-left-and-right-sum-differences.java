class Solution {
    public int[] leftRightDifference(int[] nums) {
        int[] ls = new int[nums.length];
        int[] rs = new int[nums.length];
        ls[0] = nums[0];
        for(int i = 1 ; i < nums.length ; i++){
            ls[i] += nums[i] + ls[i-1];
        }
        rs[nums.length - 1] = nums[nums.length-1];
        for(int i = nums.length -2 ; i >= 0 ; i--){
            rs[i] += rs[i+1] + nums[i];
        }
        int res[] = new int[nums.length];
        for(int i = 0 ; i < res.length ; i++){
            res[i] =Math.abs ( rs[i] - ls[i]);
        }
        return res;
    }
}