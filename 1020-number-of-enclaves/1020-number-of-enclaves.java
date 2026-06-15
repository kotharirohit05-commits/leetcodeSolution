class Solution {
    class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    private void bfs(int i,int j, int[][] visi , int[][] grid){

        Queue<Pair> queue = new LinkedList<>();
        int[] delr = {-1, 0, 1, 0};
        int[] delc = {0 ,-1, 0, 1};

        int n = grid.length;
        int m = grid[0].length;

        queue.add(new Pair(i,j));
        while(!queue.isEmpty()){
            int r = queue.peek().first;
            int c = queue.peek().second;
            queue.remove();
            for(int z = 0; z < 4 ; z++){
            int nr = r + delr[z];
            int nc = c + delc[z];
            if(nr >= 0 && nr < n && nc >= 0 && nc < m && visi[nr][nc] == 0 && grid[nr][nc] == 1){
               visi[nr][nc] = 1;
               queue.add(new Pair(nr, nc)); 
            }
        }
        }
        
    }
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visi = new int[n][m];
        for(int i = 0; i < m ; i++){
            if(grid[0][i] == 1){
                visi[0][i] = 1;
                bfs(0, i, visi, grid);
            }
            if(grid[n-1][i] == 1){
                visi[n-1][i] = 1;
                bfs(n-1, i, visi, grid);
            }
        }
        for(int i = 0; i < n ; i++){
            if(grid[i][0] == 1){
                visi[i][0] = 1;
                bfs(i, 0, visi, grid);
            }
            if(grid[i][m-1] == 1){
                visi[i][m-1] = 1;
                bfs(i, m-1, visi, grid);
            }
        }

        int ans = 0;
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < m ; j++){
                if(grid[i][j] == 1 && visi[i][j] == 0){
                    ans++;
                }
            }
        }
        return ans;
    }
}