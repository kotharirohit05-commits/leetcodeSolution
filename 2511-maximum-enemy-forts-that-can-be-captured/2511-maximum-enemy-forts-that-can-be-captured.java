class Solution {
    public int captureForts(int[] forts) {
        int prev = -1;
        int max = 0;
        for(int i = 0 ; i < forts.length ; i++){
            if(forts[i] != 0){

                if(prev != -1 && forts[i] != forts[prev]){
                    max = Math.max(max , i - prev - 1 );
                }

                prev = i;
            }
        }
        return max;
    }
}