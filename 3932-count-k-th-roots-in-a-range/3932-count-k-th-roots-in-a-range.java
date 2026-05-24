class Solution {
    public int countKthRoots(int l, int r, int k) {
        int low = 0 ;
        int high = r;
        int start = -1;
        while( low <= high){
            int mid = low + ( high - low ) / 2;
            double val = Math.pow(mid , k);
            if(val >= l){
                start = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        low = 0;
        high = r;

        int end = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            double val = Math.pow(mid , k);
            if(val <= r){
                end = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        if(start == -1 || end == -1 || start > end){
            return 0;
        }
        return end - start + 1;

    }
}