class Solution {
    public int minElement(int[] nums) {
        int ans = Integer.MAX_VALUE;
        for(int i = 0 ; i < nums.length ; i++){
            int val = nums[i];
            int sum = 0;
            while( val > 0 ){
                int dig = val % 10;
                sum += dig;
                val = val / 10;
            }
            nums[i] = sum;
            ans = Math.min(sum , ans);
        }
        return ans;
    }
}