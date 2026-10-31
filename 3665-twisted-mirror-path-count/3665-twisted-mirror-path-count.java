class Solution {
    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int MOD = 1_000_000_007;
        
        // Destination maps: store new int[]{target_row, target_col} or null if out of bounds
        int[][][] landRight = new int[m][n][];
        int[][][] landDown = new int[m][n][];
        
        // Compute landing positions from bottom-right to top-left
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) {
                    int[] currentCell = new int[]{i, j};
                    landRight[i][j] = currentCell;
                    landDown[i][j] = currentCell;
                } else {
                    // If entering from left (moving right), deflect down into (i+1, j)
                    if (i + 1 < m) {
                        landRight[i][j] = landDown[i + 1][j];
                    } else {
                        landRight[i][j] = null;
                    }
                    
                    // If entering from above (moving down), deflect right into (i, j+1)
                    if (j + 1 < n) {
                        landDown[i][j] = landRight[i][j + 1];
                    } else {
                        landDown[i][j] = null;
                    }
                }
            }
        }
        
        // DP array to store number of valid paths from (i, j) to (m-1, n-1)
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = 1; // Base case: destination reached
        
        // Process states from bottom to top, right to left
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    continue;
                }
                
                // Paths can only originate / pause at empty cells
                if (grid[i][j] == 0) {
                    long paths = 0;
                    
                    // Option 1: Attempt to move Right to (i, j+1)
                    if (j + 1 < n) {
                        int[] dest = landRight[i][j + 1];
                        if (dest != null) {
                            paths = (paths + dp[dest[0]][dest[1]]) % MOD;
                        }
                    }
                    
                    // Option 2: Attempt to move Down to (i+1, j)
                    if (i + 1 < m) {
                        int[] dest = landDown[i + 1][j];
                        if (dest != null) {
                            paths = (paths + dp[dest[0]][dest[1]]) % MOD;
                        }
                    }
                    
                    dp[i][j] = (int) paths;
                }
            }
        }
        
        return dp[0][0];
    }
}
