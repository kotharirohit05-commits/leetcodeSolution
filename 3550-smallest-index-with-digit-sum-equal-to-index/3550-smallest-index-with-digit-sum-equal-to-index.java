class Solution {
    public int smallestIndex(int[] nums) {
        
        int ans = -1;
        for(int i = 0; i < nums.length; i++){
            if(helper(nums[i]) == i){
                return i;
            }
        }
        return ans;
    }

    private int helper(int num){
        int sum = 0;
        while(num > 0){
            int dig = num % 10;
            sum += dig;
            num /= 10;
        }
        return sum;
    }

}