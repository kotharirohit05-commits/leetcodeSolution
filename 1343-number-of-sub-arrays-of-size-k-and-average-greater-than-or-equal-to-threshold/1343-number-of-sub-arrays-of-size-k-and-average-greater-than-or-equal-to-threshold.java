class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int l = 0 ;
        int n = arr.length;
        int count = 0 , sum = 0;
        int avg = 0;

        for(int i = 0 ; i < k ; i++){
            sum += arr[i];
            
        }
        avg = (int)((double)sum / (double)k);
            if(avg >= threshold) count++;
         System.out.println(avg +  " " + count);
        for(int r = k ; r < n ; r++){
            sum += arr[r];
            sum -= arr[l];
            avg = (int)((double)sum / (double)k);
           
            if(avg >= threshold) count++;
            l++;
        }
        return count;
    }

}