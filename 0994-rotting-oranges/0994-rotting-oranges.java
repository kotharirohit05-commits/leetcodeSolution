class Solution {
    class Pair{
        int row;
        int col;
        int time;
        Pair(int row, int col, int time){
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> queue = new LinkedList<>();
        int[][] visi = new int[n][m];
        int normalOranges = 0;

        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    visi[i][j] = 2;
                    queue.add(new Pair(i,j,0));
                }else if(grid[i][j] == 1){
                    normalOranges++;
                }
            }
        }

        int count = 0;
        int time = 0;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        System.out.println(count);

        while(!queue.isEmpty()){
            int r = queue.peek().row;
            int c = queue.peek().col;
            int t = queue.peek().time;
            queue.remove();
            time = Math.max(time, t);
            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && visi[nr][nc] == 0 && grid[nr][nc] == 1){
                    visi[nr][nc] = 2;
                    queue.add(new Pair(nr, nc, time + 1));
                    count++;
                }
            }
        }
        return count == normalOranges ? time : -1;
    }
}