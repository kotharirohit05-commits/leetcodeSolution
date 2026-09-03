class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 1;
        int high = 0;
        
        for(int i = 0 ; i < weights.length ; i++){           
            high += weights[i];
            low = Math.max(weights[i], low);
        }

        while(low <= high){
            int mid = low + (high - low) / 2;
            int ans = helper(weights, mid);
            if(ans <= days){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;

    }

    private int helper(int[] weights, int mid){
        int count = 1;
        int handling = 0;
        for(int i = 0; i < weights.length; i++){
            if(weights[i] + handling <= mid){
                handling += weights[i];
            }else{
                count++;
                handling = weights[i];
            }
        }
        return count;        
    }

}