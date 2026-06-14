class Solution {
    class Pair{
        int row;
        int col;
        int time;
        Pair(int row,int col,int time){
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    public int orangesRotting(int[][] grid) {
        int normaloranges = 0;
        int n = grid.length;
        int m = grid[0].length;
        int[][] visi = new int[n][m];
        Queue<Pair> queue = new LinkedList<>();

        for(int i = 0; i < n ; i++){
            for(int j = 0 ; j < m; j++){
                if(grid[i][j] == 2){
                    visi[i][j] = 2;
                    queue.add(new Pair(i, j, 0));
                }else if(grid[i][j] == 1){
                    normaloranges++;
                }else{
                    visi[i][j] = 0;
                }
            }
        }
        int time = 0;
        int count = 0;

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        while(!queue.isEmpty()){
            int r = queue.peek().row;
            int c = queue.peek().col;
            int t = queue.peek().time;
            queue.remove();
            time = Math.max(time , t);
            for(int i = 0; i < 4 ; i++){
                int nr = r + drow[i];
                int nc = c + dcol[i];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1 && visi[nr][nc] == 0){
                    queue.add(new Pair(nr, nc, t + 1));
                    visi[nr][nc] = 2;
                    count++;
                }
            }
        }if(count != normaloranges) return -1;
        return time;
    }
}