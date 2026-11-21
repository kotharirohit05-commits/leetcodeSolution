class Solution {
    public int countConsistent(int[] nums) {

        int count = 0;
        for(int i = 0; i < nums.length; i++){
            int ans = nums[i];
            int min = Integer.MAX_VALUE;
            for(int j = i; j < nums.length; j++){
                
                ans = ans & nums[j];
                min = Math.min(min, nums[j]);
                if(ans == min){
                    count++;
                    
                }

            }
        }

        return count;

    }
}