class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1_000_000_007;
        int evenCount = 1; 
        int oddCount = 0;
        int prefixSum = 0;
        int ans = 0;

        for (int num : arr) {
            prefixSum += num;
            if (prefixSum % 2 != 0) {
                ans = (ans + evenCount) % MOD;
                oddCount++;
            } else {
                ans = (ans + oddCount) % MOD;
                evenCount++;
            }
        }

        return ans;
    }
}
