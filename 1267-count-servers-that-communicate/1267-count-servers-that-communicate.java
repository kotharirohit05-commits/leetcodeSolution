class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[] rowCount = new int[m];
        int[] colCount = new int[n];
        
        // Step 1: Count total servers in each row and column
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    rowCount[r]++;
                    colCount[c]++;
                }
            }
        }
        
        // Step 2: Sum up servers that can communicate with at least one other server
        int communicatingServers = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    if (rowCount[r] > 1 || colCount[c] > 1) {
                        communicatingServers++;
                    }
                }
            }
        }
        
        return communicatingServers;
    }
}
