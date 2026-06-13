class Solution {
    private int perimeter ;
    private void dfs(int row , int col, int[][] visi, int[][] grid){

        visi[row][col] = 1;
        int n = grid.length;
        int m = grid[0].length;

        int[] drow = {-1, 0 , 1 , 0};
        int[] dcol = {0, 1, 0 , -1};
        for(int i = 0 ; i < 4; i++){
            int nr = row + drow[i];
            int nc = col + dcol[i];
            if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                perimeter++;
            }else if (grid[nr][nc] == 0) {
                perimeter++;
            }else if (visi[nr][nc] == 0) {
                dfs(nr, nc, visi, grid);
            }
        }


    }
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visi = new int[n][m];
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < m ; j++){
                if(visi[i][j] == 0 && grid[i][j] == 1){
                    dfs(i,j,visi,grid);
                }
            }
        }
        return perimeter ;

    }
}