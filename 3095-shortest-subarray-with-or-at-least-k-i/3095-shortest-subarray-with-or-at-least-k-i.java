class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int len = Integer.MAX_VALUE;
        
        for(int i  = 0 ; i < n ; i++){
            int ans = nums[i];
            for(int j = i ; j < n ;j++){
                ans = ans | nums[j];
                if(ans >= k){
                len = Math.min(len , j - i + 1);
                }
            }

        }
        if(len == Integer.MAX_VALUE) return -1;
        return len;
    }
}