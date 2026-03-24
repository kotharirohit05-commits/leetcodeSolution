class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;

        for(int k = 0 ; k < m ; k++){
            int max = 0;

            for(int i = 0 ; i < n ; i++){
                int index = -1;
                int rmax = 0;

                for(int j = 0 ; j < m ; j++){

                    if(grid[i][j] > rmax){
                        rmax = grid[i][j];
                        index = j;
                    }



                }
                grid[i][index] = 0;
                
                max = Math.max(rmax , max);
            }
            ans += max;
        }
        return ans;


        
    }
}