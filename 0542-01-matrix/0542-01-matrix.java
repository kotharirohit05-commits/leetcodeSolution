class Solution {
    class Pair{
        int first;
        int second;
        int third;
        Pair(int first, int second, int third){
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Queue<Pair> queue = new LinkedList<>();
        int[][] visi = new int[n][m];
        int[][] ans = new int[n][m];

        for(int i = 0; i < n ; i++){
            for(int j = 0; j < m ; j++){
                if(mat[i][j] == 0){
                    visi[i][j] = 1;
                    queue.add(new Pair(i,j,0));
                }
            }
        }

        int[] delr = {-1, 0, 1, 0};
        int[] delc = {0, 1, 0, -1};

        while(!queue.isEmpty()){

            int r = queue.peek().first;
            int c = queue.peek().second;
            int d = queue.peek().third;
            queue.remove();
            ans[r][c] = d;

            for(int i = 0; i < 4; i++){
                int nr = r + delr[i];
                int nc = c + delc[i];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && visi[nr][nc] == 0){
                    visi[nr][nc] = 1;
                    queue.offer(new Pair(nr, nc, d+1));
                }
            }
            
        }
        return ans;

    }
}