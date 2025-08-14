class Solution {
    public int[][] transpose(int[][] matrix) {
        int i = matrix.length; // row
        int j = matrix[0].length;
        int[][] t = new int[j][i];
        for (int z= 0 ; z < j ; z++){
            for(int x = 0 ; x < i ; x++){
                t[z][x] = matrix[x][z];
            }
        }
        return t;
    }
}