class Solution {
    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < nums.length ; i++){
            min = Math.min(nums[i] , min);
            max = Math.max(nums[i] , max);
        }
        //System.out.println(max);
        int ans = 0;
        for(int i = 1 ; i <= max ; i++){
            if((min % i == 0) && (max % i == 0)){
                ans = i;
            }
        }
        return ans;
    }
}