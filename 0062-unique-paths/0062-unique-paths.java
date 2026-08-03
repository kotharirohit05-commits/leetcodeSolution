class Solution {
    public int uniquePaths(int r, int c) {

        int[] prev = new int[c];

        for (int i = 0; i < r; i++) {
            
            int[] cur = new int[c];

            for (int j = 0; j < c; j++) {
                
                if (i == 0 && j == 0)
                    cur[j] = 1;
                else {
                    int up = 0;
                    int left = 0;
                    if (i > 0)
                        up = prev[j];
                    if (j > 0)
                        left = cur[j - 1];
                    cur[j] = up + left;
                }
            }
            prev = cur;
        }
        return prev[c-1];
    }
}