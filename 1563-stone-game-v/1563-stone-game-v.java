class Solution {
    private int[][] memo;
    private int[] prefSum;

    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        memo = new int[n][n];
        prefSum = new int[n + 1];
        
        // Precompute prefix sums for O(1) subarray sum queries
        for (int i = 0; i < n; i++) {
            prefSum[i + 1] = prefSum[i] + stoneValue[i];
        }
        
        return solve(0, n - 1);
    }

    private int solve(int i, int j) {
        // Base case: Only one stone left, no more splits possible
        if (i == j) {
            return 0;
        }
        
        // Return cached result if already computed
        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        int maxScore = 0;

        // Try every possible split point k
        for (int k = i; k < j; k++) {
            int leftSum = prefSum[k + 1] - prefSum[i];
            int rightSum = prefSum[j + 1] - prefSum[k + 1];

            if (leftSum < rightSum) {
                // Bob throws away the right row
                maxScore = Math.max(maxScore, leftSum + solve(i, k));
            } else if (leftSum > rightSum) {
                // Bob throws away the left row
                maxScore = Math.max(maxScore, rightSum + solve(k + 1, j));
            } else {
                // Sums are equal, Alice chooses the path maximizing her score
                int chooseLeft = leftSum + solve(i, k);
                int chooseRight = rightSum + solve(k + 1, j);
                maxScore = Math.max(maxScore, Math.max(chooseLeft, chooseRight));
            }
        }

        return memo[i][j] = maxScore;
    }
}
