class Solution {
    class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    private void bfs(int ro, int co, int[][] vis, char[][] grid){
        vis[ro][co] = 1;
        Queue<Pair>queue = new LinkedList<>();
        queue.offer(new Pair(ro,co));
        int n = grid.length;
        int m = grid[0].length;

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        while(!queue.isEmpty()){
            int row = queue.peek().first;
            int col = queue.peek().second;
            queue.remove();

            for(int i = 0 ; i < 4; i++){
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];
                if(nrow >= 0 && nrow < n && ncol>=0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == '1'){
                    vis[nrow][ncol] = 1;
                    queue.offer(new Pair(nrow,ncol));
                }
            }
        

        }
        
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        int[][] vis = new int[n][m];
        for(int row = 0 ; row < n ; row++){
            for(int col = 0 ; col < m ; col++){
                if(vis[row][col] == 0 && grid[row][col] == '1'){
                    count++;
                    bfs(row, col, vis, grid);
                }
            }
        }
        return count;
    }
}