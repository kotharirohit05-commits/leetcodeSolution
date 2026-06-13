class Solution {
    private int dfs(int row, int col, int[][] copy, int[][] grid){
        
        copy[row][col] = 1;

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        int n = grid.length;
        int m = grid[0].length;
        int area = 1;

        for(int i = 0; i < 4; i++){
            int nr = row + drow[i];
            int nc = col + dcol[i];
            if(nr >= 0 && nr < n && nc >= 0 && nc < m && copy[nr][nc] == 0 && grid[nr][nc] == 1){
                
                area += dfs(nr, nc ,copy, grid);
            }
        }
        return area;

    }



    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] copy = new int[n][m];
        int maxArea =0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1 && copy[i][j] == 0){
                     maxArea = Math.max(
                        maxArea,
                        dfs(i, j, copy, grid)
                    );
                }
            }
        }
        return maxArea;
        
    }
}