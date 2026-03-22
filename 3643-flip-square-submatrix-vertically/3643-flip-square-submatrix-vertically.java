class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int trow = x;
        int brow = x + k - 1;
        while(trow < brow){
            for(int i = y ; i <y + k ; i++){
                int temp = grid[trow][i];
                grid[trow][i] = grid[brow][i];
                grid[brow][i] = temp;
            }
            trow++;
            brow--;
        }
        return grid;
    }
}