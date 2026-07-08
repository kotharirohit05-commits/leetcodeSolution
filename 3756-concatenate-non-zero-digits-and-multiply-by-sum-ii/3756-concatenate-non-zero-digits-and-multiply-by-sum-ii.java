class Solution {

    static final int MOD = 1000000007;

    public int[] sumAndMultiply(String s, int[][] queries) {

        int n = s.length();

        
        int[] prefixSum = new int[n + 1];

        
        int[] before = new int[n];
        int[] upto = new int[n];

        StringBuilder comp = new StringBuilder();

        int cnt = 0;

        for (int i = 0; i < n; i++) {

            before[i] = cnt;

            int d = s.charAt(i) - '0';

            prefixSum[i + 1] = prefixSum[i];

            if (d != 0) {
                comp.append(s.charAt(i));
                cnt++;
                prefixSum[i + 1] += d;
            }

            upto[i] = cnt;
        }

        int m = comp.length();

        long[] pow10 = new long[m + 1];
        long[] hash = new long[m + 1];

        pow10[0] = 1;

        for (int i = 1; i <= m; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        for (int i = 0; i < m; i++) {
            int d = comp.charAt(i) - '0';
            hash[i + 1] = (hash[i] * 10 + d) % MOD;
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int l = queries[i][0];
            int r = queries[i][1];

            int sum = prefixSum[r + 1] - prefixSum[l];

            if (sum == 0) {
                ans[i] = 0;
                continue;
            }

            int left = before[l];
            int right = upto[r];

            int len = right - left;

            long x = hash[right] - (hash[left] * pow10[len]) % MOD;

            if (x < 0) x += MOD;

            ans[i] = (int) ((x * sum) % MOD);
        }

        return ans;
    }
}