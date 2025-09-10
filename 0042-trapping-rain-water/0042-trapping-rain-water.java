class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        int[] lb = new int[n];
        lb[0] = arr[0];
        for(int i = 1 ; i < n ; i++){
            lb[i] = Math.max(lb[i-1] , arr[i]);
        }
        int[] rb = new int[n];
        rb[n-1] = arr[n-1];
        for(int i = n-2 ; i >= 0  ; i--){
            rb[i] = Math.max(rb[i+1] , arr[i]);
        }
        int ans = 0;
        for(int i = 1 ; i < n ; i++ ){
            ans += (Math.min(lb[i],rb[i]) )- arr[i];
        }
        return ans;
    }
}