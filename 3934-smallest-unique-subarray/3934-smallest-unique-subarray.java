import java.util.HashSet;
import java.util.Set;

class Solution {
    private static final long BASE1 = 1315423911L;
    private static final long MOD1 = 1000000007L;
    private static final long BASE2 = 1313131L;
    private static final long MOD2 = 1000000009L;

    private long[] p1, p2, h1, h2;
    private int n;

    public int smallestUniqueSubarray(int[] nums) {
        n = nums.length;
        p1 = new long[n + 1];
        p2 = new long[n + 1];
        h1 = new long[n + 1];
        h2 = new long[n + 1];

        p1[0] = 1;
        p2[0] = 1;

        for (int i = 0; i < n; i++) {
            p1[i + 1] = (p1[i] * BASE1) % MOD1;
            p2[i + 1] = (p2[i] * BASE2) % MOD2;
            h1[i + 1] = (h1[i] * BASE1 + nums[i]) % MOD1;
            h2[i + 1] = (h2[i] * BASE2 + nums[i]) % MOD2;
        }

        int left = 1, right = n;
        int ans = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (hasUnique(mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    private boolean hasUnique(int length) {
        Set<Long> seenOnce = new HashSet<>();
        Set<Long> seenMultiple = new HashSet<>();

        for (int i = 0; i <= n - length; i++) {
            long hash1 = (h1[i + length] - (h1[i] * p1[length]) % MOD1 + MOD1) % MOD1;
            long hash2 = (h2[i + length] - (h2[i] * p2[length]) % MOD2 + MOD2) % MOD2;
            
            // Pack both hashes into a single 64-bit long
            long key = (hash1 << 32) | hash2;

            if (seenMultiple.contains(key)) {
                continue;
            }
            if (seenOnce.contains(key)) {
                seenOnce.remove(key);
                seenMultiple.add(key);
            } else {
                seenOnce.add(key);
            }
        }

        return !seenOnce.isEmpty();
    }
}
