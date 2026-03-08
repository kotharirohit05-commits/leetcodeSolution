class Solution {
    public int smallestBalancedIndex(int[] nums) {
        long sum = 0;
        for(int n : nums){
            sum += n;
        }
        long prod = 1;
        for(int i = nums.length - 1 ; i >= 0 ; i--){
            sum -= nums[i];
            if(sum == prod) return i;
            if(prod > sum) break;
            if((prod > (long)(1e18) / nums[i])) break;



            prod *= nums[i];
        }
        return -1;
    }
}