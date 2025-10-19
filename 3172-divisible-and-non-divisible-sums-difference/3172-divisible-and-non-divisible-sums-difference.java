class Solution {
    public int differenceOfSums(int n, int m) {
        int[] arr = new int[n];
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        if(m > n) return (n*(n+1)/2);
        int k = 0;
        for(int i = 0 ; i < n ; i++){
            arr[k++] = i+1;
        
        }
        int idx = 0;
        int idex = 0;
        for(int i = 0 ; i < n ; i++){
            if(arr[i] % m != 0){
                arr1[idx++] = arr[i];
            }
            else{
                arr2[idex++] = arr[i];
            }
        }
        int sum1 = 0;
        int sum2 = 0;
        for(int i = 0 ; i < n ; i++){
            sum1 += arr1[i];
        }
        for(int i = 0 ; i < n ; i++){
            sum2 += arr2[i];
        }
        int ans = sum1 - sum2 ;
        return ans;
    }
   
}