class Solution {
    public int minimumIndex(int[] capacity, int itemSize) {
        int max = (int)1e9 ;
        int idx = -1;
        for(int i = 0 ; i < capacity.length ; i++){
            if( capacity[i] < max && capacity[i] >= itemSize){
                max = capacity[i];
                idx = i;
            }
        }
        return idx;
    }
}