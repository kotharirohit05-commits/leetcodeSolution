class Solution {
    public String[] createGrid(int m, int n) {
        char[][] mat = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = '#';
            }
        }
        if(m == 1){
            for(int i = 0; i < n; i++){
                mat[0][i] = '.';
            }
        }
        else if(n == 1){
            for(int i = 0; i < m; i++){
                mat[i][0] = '.';
            }
        }
        else{
            for(int i =0; i < m; i++){
                mat[i][0] = '.';
            }
            for(int j =0; j < n; j++){
                mat[m-1][j] = '.';
            }
        }
        String[] ans = new String[m ];
        for(int i =0; i < m  ; i++){
            ans[i] = new String(mat[i]);
        }
        return ans;
    }
}