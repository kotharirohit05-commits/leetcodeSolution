class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for(int p : piles){
            high = Math.max(p ,high);
        }
        while(low < high ){
            int mid = low + (high - low) / 2;
            long hours = 0;
            for(int n : piles){
                hours += (n + mid - 1)/mid;
            }
            if(hours <= h){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}