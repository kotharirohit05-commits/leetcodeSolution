class Solution {

    private boolean isValid(int i, int j, boolean[][] visi, char[][] board, int idx, String word) {

        if (idx == word.length()) {
            return true;
        }
        int n = board.length;
        int m = board[0].length;

        visi[i][j] = true;

        int[] delRow = { -1, 0, 1, 0 };
        int[] delCol = { 0, 1, 0, -1 };

        for(int k = 0; k < 4; k++){
            int nr = delRow[k] + i;
            int nc = delCol[k] + j;
            if(nr >= 0 && nr < n && nc >= 0 && nc < m && !visi[nr][nc] && board[nr][nc] == word.charAt(idx)){
                
                if(isValid(nr, nc, visi, board, idx + 1, word)){
                    return true;
                }
            }
        }
        visi[i][j] = false;
        return false;

    }

    public boolean exist(char[][] board, String word) {

        boolean[][] visi = new boolean[board.length][board[0].length];
        int idx = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && isValid(i, j, visi, board, 1, word)) {
                    return true;
                }
            }
        }

        return false;

    }
}