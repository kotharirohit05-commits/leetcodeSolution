class Solution {
    public int findPoisonedDuration(int[] ts , int d) {
        
        int ans = 0;

        for(int i = 1 ; i < ts.length ; i++){

            ans +=  Math.min(ts[i] - ts[i-1] , d);
            


        }
        return ans + d;

    }
}