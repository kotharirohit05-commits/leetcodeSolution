class Solution {
    public List<Integer> zigzagTraversal(int[][] grid) {
        List<Integer> ans = new ArrayList<>();
        int n = grid[0].length;
        int m = grid.length;
        boolean addThis = true;
        for(int i = 0 ; i < m ; i++){
             if (i % 2 == 0) {

                for (int j = 0; j < n; j++) {

                    if (addThis) {
                        ans.add(grid[i][j]);
                    }

                    addThis = !addThis;
                }
            }

            // right -> left
            else {

                for (int j = n - 1; j >= 0; j--) {

                    if (addThis) {
                        ans.add(grid[i][j]);
                    }

                    addThis = !addThis;
                }
            }
        }
        return ans;
    }
}