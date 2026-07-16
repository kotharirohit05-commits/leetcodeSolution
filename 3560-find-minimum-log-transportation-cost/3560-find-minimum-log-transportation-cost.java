class Solution {
    public long minCuttingCost(int n, int m, int k) {
        long ans = 0;
        if (n > k) {
            ans += (long) k * (n - k);
        }
        if (m > k) {
            ans += (long) k * (m - k);
        }

        return ans;
    }
}
