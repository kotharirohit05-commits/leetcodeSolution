class Solution {

    private int helper(String s , String t, int i , int j, int[][] dp){

        if(i < 0 || j < 0){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }


        if(s.charAt(i) == t.charAt(j)){
            return dp[i][j] = 1 + helper(s, t, i - 1, j - 1, dp);
        }else{
            return dp[i][j] = Math.max(helper(s, t, i - 1, j, dp) , helper(s, t, i , j -1, dp));
        }

        

    }

    public int longestPalindromeSubseq(String s) {
        
        StringBuilder sb = new StringBuilder(s);
        String t = sb.reverse().toString();
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n][m];
        for(int[] x: dp){
            Arrays.fill(x, -1);
        }

        return helper(s, t, n - 1, m - 1, dp);

    }
}