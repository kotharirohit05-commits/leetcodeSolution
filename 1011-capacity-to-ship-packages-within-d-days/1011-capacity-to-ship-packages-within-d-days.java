class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;
        for(int i = 0 ; i < weights.length ; i++){
            low = Math.max(low , weights[i]);
            high += weights[i];
        }
        while(low < high){
            int mid = low + ( high - low ) / 2;
            if(canDays(weights , days , mid)) {
            high = mid;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
    private boolean canDays(int[] weights , int days , int capacity){
        int reqdays = 1 ;
        int currentload = 0 ;
        for(int w : weights){
            if(currentload + w > capacity){
                reqdays++;
                currentload = 0;
            }
            currentload += w;
        }
        return reqdays <= days;
    }
}