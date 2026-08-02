class Solution {
    private long gcd(long a, long b){
        return (b==0) ? a : gcd(b , a % b);
    }
    public long maxPairStrength(int[] nums) {
        long ans = 0;
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length; j++){
                long gf = gcd(nums[i], nums[j]);
                long g = gf * gf;
                long calc = ((long)nums[i] * nums[j]) /  g;
                ans = Math.max(ans, calc);
            }
        }
        return ans;
    }
}