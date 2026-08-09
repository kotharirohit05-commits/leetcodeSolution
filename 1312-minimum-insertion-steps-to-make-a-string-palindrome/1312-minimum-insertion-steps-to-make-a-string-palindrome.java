class Solution {
    private int helper(String s1, String s2, int i , int j,int[][] dp){

        if(i < 0 || j< 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = 1 + helper(s1, s2, i - 1, j - 1, dp);
        }else{
            return dp[i][j] =  Math.max(helper(s1, s2, i , j - 1, dp), helper(s1, s2, i - 1, j, dp));
        }

    }
    public int minInsertions(String s) {
        StringBuilder sb = new StringBuilder(s);
        String t = sb.reverse().toString();
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int[] x : dp){
            Arrays.fill(x, -1);
        }
        return n - helper(s, t, n-1, n-1, dp);
    }
}