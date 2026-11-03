class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        
        int z = nums[n-1];
        int sum = 0;
        for(int i = 0; i < n ; i++){
            if(nums[i] != z){
                sum += z - nums[i];
            }
        }
        return sum;
    }
}