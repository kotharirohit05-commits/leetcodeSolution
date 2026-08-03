class Solution {

    private int helper(int i, int j, int[][] obstacleGrid, int[][] dp) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        if (i >= n || j >= m)
            return 0;

        if (obstacleGrid[i][j] == 1)
            return 0;

        if (i == n - 1 && j == m - 1 && obstacleGrid[i][j] == 0) {
            return 1;
        }

        if (dp[i][j] != -1)
            return dp[i][j];

        dp[i][j] = helper(i + 1, j, obstacleGrid, dp) + helper(i, j + 1, obstacleGrid, dp);

        return dp[i][j];

    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(0, 0, obstacleGrid, dp);

    }
}