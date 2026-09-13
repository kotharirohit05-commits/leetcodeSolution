class Solution {
    public int[][] cyclicShift(int n, int[][] grid, int[] rowShift, int[] colShift) {

        int[][] mat = new int[n][n];

        for (int rs = 0; rs < rowShift.length; rs++) {

            int shifts = rowShift[rs];
            int l = 0;

            for (int j = shifts; j < n; j++) {
                mat[rs][l] = grid[rs][j];
                l++;
            }
           
            for(int j = 0; j < shifts; j++){
                mat[rs][l] = grid[rs][j];
                l++;
            }    

        }

        
        for (int cs = 0; cs < colShift.length; cs++) {

            int shifts = colShift[cs];
            int l = 0;

            for (int j = shifts; j < n; j++) {
                grid[l][cs] = mat[j][cs];
                l++;
            }
           
            for(int j = 0; j < shifts; j++){
                grid[l][cs] = mat[j][cs];
                l++;
            }    

        }


        
        return grid;
    

    }
}