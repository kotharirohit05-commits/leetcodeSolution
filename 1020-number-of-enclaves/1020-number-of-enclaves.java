class Solution {
    class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public int numEnclaves(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> queue = new LinkedList<>();
        boolean[][] visi = new boolean[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 || j == 0 || i == n - 1 || j == m -1){
                    if(grid[i][j] == 1){
                        queue.add(new Pair(i,j));
                        visi[i][j] = true;
                    }
                }
            }
        }

        int[] dr = { -1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while(!queue.isEmpty()){
            int r = queue.peek().first;
            int c = queue.peek().second;
            queue.poll();
            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1 && !visi[nr][nc]){
                    queue.add(new Pair(nr,nc));
                    visi[nr][nc] = true;
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1 && !visi[i][j]){
                    ans++;
                }
            }
        }
        return ans;

    }
}