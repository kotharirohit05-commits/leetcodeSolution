class Solution {
    public long maximumValue(int n, int s, int m) {

        if (n == 1) return s;

        long ans = s;
        long p1 = n / 2;
        long p2 = (n - 1L) / 2;

        long ans1 = s;
        if (p1 > 0) {
            ans1 = (long) s + p1 * m - p1 + 1;
        }

        long ans2 = (long) s + p2 * (m - 1L);

        return Math.max(ans, Math.max(ans1, ans2));
    }
}