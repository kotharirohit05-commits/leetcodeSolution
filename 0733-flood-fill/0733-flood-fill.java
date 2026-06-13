class Solution {
    private void dfs(int[][] image, int[][] ans, int initial, int sr, int sc, int color){

        ans[sr][sc] = color;
        int n = image.length;
        int m = image[0].length;
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0 ,-1};

        for(int i = 0 ; i < 4 ; i++){
            int nr = sr + drow[i];
            int cr = sc + dcol[i];
            if(nr >= 0 && nr < n && cr >= 0 && cr < m && ans[nr][cr] != color && image[nr][cr] == initial){
                dfs(image, ans, initial, nr, cr, color);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int[][] ans = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                ans[i][j] = image[i][j];
            }
        }
        int initial = image[sr][sc];
        dfs(image, ans, initial, sr, sc, color);
        return ans;
    }
}