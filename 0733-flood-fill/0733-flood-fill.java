class Solution {

    class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int[][] mat = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                mat[i][j] = image[i][j];
            }
        }
        
        Queue<Pair> queue = new LinkedList<>();
        
        int startcolour = image[sr][sc];
        
        
        if(mat[sr][sc] != color){
            queue.add(new Pair(sr,sc));
            mat[sr][sc] = color;
        }
            
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, -1, 0, 1};

        while(!queue.isEmpty()){
            int r = queue.peek().row;
            int c = queue.peek().col;
            queue.remove();
            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m  && mat[nr][nc] == startcolour){
                    mat[nr][nc] = color;
                    queue.add(new Pair(nr,nc));
                }
            }

        }
        return mat;

    }
}