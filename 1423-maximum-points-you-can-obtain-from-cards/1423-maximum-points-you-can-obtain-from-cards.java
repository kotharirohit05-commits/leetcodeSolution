class Solution {
    public int maxScore(int[] nums, int k) {
        int ls = 0;
        int rs = 0;
        int ms = 0;

        for(int i = 0 ; i < k ; i++){
             ls += nums[i];
        }

        ms = ls;
        int n = nums.length;
        int l = k-1;
        int p = nums.length - 1;

        for(int i = k-1 ; i >= 0 ; i--){
            ls -= nums[i];
            rs += nums[p];
            ms = Math.max(ms , rs + ls);
            p--;
        }
        return ms;

    }
}