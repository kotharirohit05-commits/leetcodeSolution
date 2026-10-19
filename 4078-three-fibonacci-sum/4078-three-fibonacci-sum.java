class Solution {
    public boolean threeFibonacciSum(int n) {
        int[] arr = new int[100000];
        arr[0] = 0;
        arr[1] = 1;
        for(int i = 2; i < arr.length; i++){
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        if(n < 2) return false;
        
        int l = 0;
        int sum = 0;

        for(int r = 0; r < arr.length; r++){

            if(sum == n){
                return true;
            }

            while(r - l >= 3){
                sum -= arr[l];
                l++;
            }
            sum += arr[r];
            
            
        }

        return false;

    }
}