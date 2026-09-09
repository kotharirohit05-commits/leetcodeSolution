class Solution {

    class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    private int bfs(int[][] grid, int[][] visi, int row, int col){

        visi[row][col] = 1;
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(row, col));

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, -1, 0, 1};

        int count = 0;

        while(!queue.isEmpty()){
            int r = queue.peek().first;
            int c = queue.peek().second;
            queue.remove();
            count++;
            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1 && visi[nr][nc] == 0){
                    visi[nr][nc] = 1;
                    queue.add(new Pair(nr, nc));
                }
            }
        }

        return count;

    }

    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visi = new int[n][m];
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1 && visi[i][j] == 0){
                    ans = Math.max(ans, bfs(grid, visi, i, j));
                }
            }
        }
        return ans;
    }
}