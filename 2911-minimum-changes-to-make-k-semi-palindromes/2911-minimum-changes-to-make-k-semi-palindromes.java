import java.util.*;

class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        
        // Precompute proper divisors for every possible substring length
        List<Integer>[] divisors = new ArrayList[n + 1];
        for (int len = 2; len <= n; len++) {
            divisors[len] = new ArrayList<>();
            for (int d = 1; d < len; d++) {
                if (len % d == 0) {
                    divisors[len].add(d);
                }
            }
        }
        
        // Precompute cost[i][j]: min changes to make s[i..j] a semi-palindrome
        int[][] cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                cost[i][j] = getCost(s, i, j, divisors[j - i + 1]);
            }
        }
        
        // dp[p][i]: min changes to partition s[0..i-1] into p semi-palindromes
        int INF = 1_000_000_000;
        int[][] dp = new int[k + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }
        dp[0][0] = 0;
        
        for (int p = 1; p <= k; p++) {
            // Each partition needs at least 2 characters, so i >= 2 * p
            for (int i = 2 * p; i <= n; i++) {
                // Previous split point j must allow p - 1 parts (j >= 2 * (p - 1))
                // and leave at least 2 characters for the current part (j <= i - 2)
                for (int j = 2 * (p - 1); j <= i - 2; j++) {
                    if (dp[p - 1][j] != INF) {
                        dp[p][i] = Math.min(dp[p][i], dp[p - 1][j] + cost[j][i - 1]);
                    }
                }
            }
        }
        
        return dp[k][n];
    }
    
    private int getCost(String s, int l, int r, List<Integer> divs) {
        int minChanges = Integer.MAX_VALUE;
        
        for (int d : divs) {
            int changes = 0;
            // Check each of the d interleaved subsequences
            for (int offset = 0; offset < d; offset++) {
                int left = l + offset;
                int right = r - (d - 1 - offset);
                
                while (left < right) {
                    if (s.charAt(left) != s.charAt(right)) {
                        changes++;
                    }
                    left += d;
                    right -= d;
                }
            }
            minChanges = Math.min(minChanges, changes);
        }
        
        return minChanges;
    }
}
