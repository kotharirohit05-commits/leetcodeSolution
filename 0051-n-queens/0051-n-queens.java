class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                board[i][j] = '.';
            }
        }
        nqueens(n , 0 , board , ans);
        return ans;
    }
    public static void nqueens(int n , int row, char[][] board , List<List<String>> ans){
        if(row == n ){
            List<String> temp = new ArrayList<>();
            for(int i = 0 ; i < n ; i++){
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return ;
            
        }
        
        for(int j = 0 ; j < n ; j++){
            if (isSafe(n , row , j , board)){
                board[row][j] = 'Q';
                nqueens(n , row + 1 , board , ans);
                board[row][j] = '.';
            }
        }
    }
    public static boolean isSafe(int n ,int row ,int col , char[][] board){
    for(int j = 0 ; j < row ; j++){
        if(board[j][col] == 'Q') return false;
    }
    
    for(int i = row-1,j = col -1; i>= 0 && j>= 0 ; i--,j--){
        if(board[i][j] == 'Q') return false;
    }
    for(int i = row -1,  j = col +1 ; i>= 0 && j<n ; i--,j++){
        if(board[i][j] == 'Q') return false;
    }
    return true;
    }
    
}