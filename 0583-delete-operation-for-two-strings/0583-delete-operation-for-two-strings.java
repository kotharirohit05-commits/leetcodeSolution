class Solution {

    private int helper(String s1, String s2, int i, int j,int[][] dp){

        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = 1 + helper(s1, s2 , i - 1, j - 1, dp);
        }
        else{
            return dp[i][j] =  Math.max(helper(s1, s2, i - 1, j, dp), helper(s1, s2, i , j - 1, dp));
        }

    }

    public int minDistance(String word1, String word2) {
        int n = word2.length();
        int[][] dp = new int[word1.length()][word2.length()];
        for(int[] x: dp){
            Arrays.fill(x, -1);
        }
        return word1.length() + word2.length() - 2 * helper(word1, word2, word1.length() - 1, word2.length() - 1, dp);
    }
}