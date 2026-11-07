class Solution {
    public long maximizeSum(int[] nums, int k) {
        long ans = 0;
        for(int x : nums){
            ans += x;
        }
        int[] newarr = new int[nums.length];
        int[] diff = new int[nums.length];
        int p = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            String ele = String.valueOf(nums[i]);
            char[] arr = ele.toCharArray();
            Arrays.sort(arr);
            StringBuilder sb = new StringBuilder(new String(arr));
            sb.reverse();
            int largeNum = Integer.parseInt(sb.toString());
            diff[i] = largeNum - nums[i];
        }
        Arrays.sort(diff);
        for(int i = nums.length  - k; i < nums.length ; i++){
            ans += diff[i];
        }
        return ans;
    }
}