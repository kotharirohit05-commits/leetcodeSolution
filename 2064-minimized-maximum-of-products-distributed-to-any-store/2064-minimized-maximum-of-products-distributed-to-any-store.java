class Solution {
    private int helper(int[] quantities, long mid){
        int count = 0;
    
        for(int i = 0; i < quantities.length; i++){
            count += (quantities[i] + mid - 1) / mid;
        }
        return count;
    }
    public int minimizedMaximum(int n, int[] quantities) {
        int len = quantities.length;
        long low = 1;
        long high = 0;
        for(int x : quantities){
            high += x;
           
        }
        while(low <= high){
            long mid = low + (high - low) / 2;
            int countshops = helper(quantities, mid);
            if(countshops <= n){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return (int)low;
    }
}