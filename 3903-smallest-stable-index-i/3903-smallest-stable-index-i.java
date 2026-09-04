class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        if(n == 0){
            return -1;
        }

        int[] suff = new int[n];
        suff[n-1] = nums[n-1];
        for(int i = n-2 ; i >= 0 ; i--){
            suff[i] = Math.min(nums[i] , suff[i+1]); 
        }
        int pref = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++){
            pref = Math.max(nums[i] , pref);
            if((pref - suff[i]) <= k) return i;
        }
        return -1;
    }
}