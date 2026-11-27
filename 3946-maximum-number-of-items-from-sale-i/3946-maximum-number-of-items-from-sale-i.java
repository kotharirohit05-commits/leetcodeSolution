import java.util.Arrays;

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int maxFactor = 0;
        for (int[] item : items) {
            maxFactor = Math.max(maxFactor, item[0]);
        }

        int[] freq = new int[maxFactor + 1];
        for (int[] item : items) {
            freq[item[0]]++;
        }

        // Precompute free items granted by buying at least 1 copy of factor f
        int[] freeByFactor = new int[maxFactor + 1];
        for (int f = 1; f <= maxFactor; f++) {
            if (freq[f] > 0) {
                int totalMultiples = 0;
                for (int m = f; m <= maxFactor; m += f) {
                    totalMultiples += freq[m];
                }
                freeByFactor[f] = totalMultiples - 1;
            }
        }

        // 0/1 Knapsack for the first copy of each item
        int[] dp = new int[budget + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int[] item : items) {
            int f = item[0];
            int p = item[1];
            minPrice = Math.min(minPrice, p);
            int val = 1 + freeByFactor[f];

            for (int c = budget; c >= p; c--) {
                if (dp[c - p] != -1) {
                    dp[c] = Math.max(dp[c], dp[c - p] + val);
                }
            }
        }

        // Spend remaining budget on the cheapest item
        int ans = 0;
        for (int c = 0; c <= budget; c++) {
            if (dp[c] != -1) {
                int extraCopies = (budget - c) / minPrice;
                ans = Math.max(ans, dp[c] + extraCopies);
            }
        }

        return ans;
    }
}
