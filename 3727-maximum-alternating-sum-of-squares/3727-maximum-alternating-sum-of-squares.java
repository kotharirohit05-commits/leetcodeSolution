class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;

        long[] dup = new long[n];

        for(int i = 0; i < n; i++){
            dup[i] = Math.abs((long)nums[i]);
        }
        Arrays.sort(dup);
        long ans = 0;
        for(int i = 0; i < n; i++){
            if(i < n / 2){
                ans -= dup[i] * dup[i];
            }else{
                ans += dup[i] * dup[i];
            }
        }

        return ans;
    }
}