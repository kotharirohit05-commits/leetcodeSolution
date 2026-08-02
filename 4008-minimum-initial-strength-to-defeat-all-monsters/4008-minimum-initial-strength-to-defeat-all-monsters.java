class Solution {

    private boolean isValid(long initialstrength, int[] monsters,long[] bonus){
        long cur = initialstrength;
        for(int i = 0; i < monsters.length; i++){
            if(cur + bonus[i] < monsters[i]){
                return false;
            }
            cur -= monsters[i];
            if(cur < 0){
                cur = 0;
            }
        }
        return true;
        
    }

    public long minInitialStrength(int[] monsters, int[][] boosts) {

        long low = 0;
        long high = 100000000000000L;
        int n = monsters.length;


        long[] diff = new long[n+1];
        for(int[] b : boosts){
            diff[b[0]] += b[2];
            if(b[1]+ 1 < diff.length){
                diff[b[1] + 1] -= b[2];
            }
        }

        long[] bonus = new long[n];
        long curr = 0;
        for (int i = 0; i < n; i++) {
            curr += diff[i];
            bonus[i] = curr;
        }
        

        
        while(low <= high){
            long mid = low + (high - low) / 2;
            
                if(isValid(mid, monsters, bonus)){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
        }

        return low;
    
    }
}