class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int a = nums[n-1];
        int b = nums[n-2];
        int c = nums[n-3];
        int d = nums[0];
        int e= nums[1];
        int f = nums[2];
        if(a*b*c > d*e*a){
        return a*b*c;
        }
        else{
            return d*e*a;
        }
    }
}