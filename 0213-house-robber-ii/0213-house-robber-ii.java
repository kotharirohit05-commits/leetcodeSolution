class Solution {
    private int solve(int idx, int[] arr, int[] dp){
        if(idx < 0) return 0;
        if(idx == 0) return arr[0];
        if(dp[idx] != -1) return dp[idx];
        int pick = arr[idx] + solve(idx - 2, arr, dp);
        int notpick = solve(idx - 1, arr, dp);
        return dp[idx] =  Math.max(pick, notpick);
    }

    public int rob(int[] nums) {

        int n = nums.length;

        if (n == 1)
            return nums[0];

        int[] arr1 = new int[n - 1];
        int[] dp1 = new int[n - 1];
        int[] arr2 = new int[n - 1];
        int[] dp2 = new int[n - 1];

        Arrays.fill(dp1 , -1);
        Arrays.fill(dp2 , -1);

        for (int i = 0; i < n - 1; i++) {
            arr1[i] = nums[i];
        }
        
        for (int i = 1; i < n; i++) {
            arr2[i-1] = nums[i];
        }

        int left = solve(n-2 , arr1, dp1);
        int right = solve(n-2, arr2, dp2);

        return Math.max(left, right);

    }
}