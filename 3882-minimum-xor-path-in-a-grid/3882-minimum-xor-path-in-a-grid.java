import java.util.Arrays;

class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxXor = 2048;
        boolean[][] dp = new boolean[n][maxXor];
        
        
        dp[0][grid[0][0]] = true;
        
        
        for (int j = 1; j < n; j++) {
            int currentVal = grid[0][j];
            for (int k = 0; k < maxXor; k++) {
                if (dp[j - 1][k]) {
                    dp[j][k ^ currentVal] = true;
                }
            }
        }
        
       
        for (int i = 1; i < m; i++) {
            boolean[][] nextDp = new boolean[n][maxXor];
            
            
            int firstColVal = grid[i][0];
            for (int k = 0; k < maxXor; k++) {
                if (dp[0][k]) {
                    nextDp[0][k ^ firstColVal] = true;
                }
            }
            
            
            for (int j = 1; j < n; j++) {
                int currentVal = grid[i][j];
                for (int k = 0; k < maxXor; k++) {
                    
                    if (dp[j][k]) {
                        nextDp[j][k ^ currentVal] = true;
                    }
                    
                    if (nextDp[j - 1][k]) {
                        nextDp[j][k ^ currentVal] = true;
                    }
                }
            }
        
            dp = nextDp;
        }
        
        
        for (int k = 0; k < maxXor; k++) {
            if (dp[n - 1][k]) {
                return k;
            }
        }
        
        return 0;
    }
}
