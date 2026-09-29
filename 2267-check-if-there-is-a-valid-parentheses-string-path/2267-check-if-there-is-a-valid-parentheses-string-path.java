class Solution {
    private Boolean[][][] memo;
    private int m, n;

    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        // A valid parentheses string must have an even length
        if ((m + n - 1) % 2 != 0) {
            return false;
        }

        // If the start is ')' or the end is '(', it can never be valid
        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(') {
            return false;
        }

        // The maximum possible balance at any point cannot exceed the maximum path length
        int maxBal = m + n;
        memo = new Boolean[m][n][maxBal];

        return dfs(grid, 0, 0, 0);
    }

    private boolean dfs(char[][] grid, int r, int c, int bal) {
        // Update balance based on current cell
        bal += (grid[r][c] == '(') ? 1 : -1;

        // If balance drops below 0, this path is invalid
        if (bal < 0) {
            return false;
        }

        // Base case: reached the bottom-right cell
        if (r == m - 1 && c == n - 1) {
            return bal == 0;
        }

        // Return cached result if already calculated
        if (memo[r][c][bal] != null) {
            return memo[r][c][bal];
        }

        boolean res = false;

        // Move Right
        if (c + 1 < n) {
            res = dfs(grid, r, c + 1, bal);
        }

        // Move Down (short-circuit if Right path already returned true)
        if (!res && r + 1 < m) {
            res = dfs(grid, r + 1, c, bal);
        }

        // Cache and return the result
        return memo[r][c][bal] = res;
    }
}
