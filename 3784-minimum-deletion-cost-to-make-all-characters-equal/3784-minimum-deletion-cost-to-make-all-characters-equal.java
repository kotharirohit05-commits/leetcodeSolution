class Solution {
    public long minCost(String s, int[] cost) {
        int n = cost.length;
        long[] ans = new long[26];
        long total = 0;

        for(int i = 0 ; i < n ; i++){
            total += cost[i];
        }

        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);
            ans[ch - 'a'] += cost[i];
        }
        
        long max = 0;
        for(long val : ans){
            max = Math.max(max , val);
        }

        return total - max;



    }
}