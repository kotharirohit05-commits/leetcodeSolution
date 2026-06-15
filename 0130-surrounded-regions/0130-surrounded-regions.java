class Solution {

    public void dfs(int i,int j, int[][] visi,char[][] board){
        visi[i][j] = 1;

        int n = board.length;
        int m = board[0].length;

        int[] delr = {-1, 0, 1, 0};
        int[] delc = {0, -1, 0, 1};
        for(int z = 0; z < 4; z++){
            int nr = i + delr[z];
            int nc = j + delc[z];
            if(nr >= 0 && nr < n && nc >= 0 && nc < m && board[nr][nc] == 'O' && visi[nr][nc] == 0){
                visi[nr][nc] = 1;
                dfs(nr, nc, visi, board);
            }
            
        }
    }

    public void solve(char[][] board) {

        int n = board.length;
        int m = board[0].length;

        int[][] visi = new int[n][m];

        for(int j = 0; j < m ; j++){
            if(visi[0][j] == 0 && board[0][j] == 'O'){
                dfs(0, j , visi, board);
            }
            if(visi[n-1][j] == 0 && board[n-1][j] == 'O')
                dfs(n-1,j , visi, board);
        }

        for(int i = 0; i < n ; i++){
            if(visi[i][0] == 0 && board[i][0] == 'O'){
                dfs(i , 0 , visi, board);
            }
            if(visi[i][m-1] == 0 && board[i][m-1] == 'O')
                dfs(i , m-1 , visi, board);
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(visi[i][j] == 0 && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
        

    }
}