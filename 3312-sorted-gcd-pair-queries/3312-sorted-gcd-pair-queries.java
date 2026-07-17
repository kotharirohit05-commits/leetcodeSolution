class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int max = 0;
        for (int x : nums) max = Math.max(max, x);

        long[] freq = new long[max + 1];
        for (int x : nums) freq[x]++;

        long[] cnt = new long[max + 1];
        for (int d = 1; d <= max; d++) {
            for (int m = d; m <= max; m += d) {
                cnt[d] += freq[m];
            }
        }

        long[] exact = new long[max + 1];
        for (int d = max; d >= 1; d--) {
            exact[d] = cnt[d] * (cnt[d] - 1) / 2;
            for (int m = d + d; m <= max; m += d) {
                exact[d] -= exact[m];
            }
        }

        long[] prefix = new long[max + 1];
        for (int d = 1; d <= max; d++) {
            prefix[d] = prefix[d - 1] + exact[d];
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            long target = queries[i] + 1; 
            int l = 1, r = max;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (prefix[mid] >= target) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            ans[i] = l;
        }

        return ans;
    }
}