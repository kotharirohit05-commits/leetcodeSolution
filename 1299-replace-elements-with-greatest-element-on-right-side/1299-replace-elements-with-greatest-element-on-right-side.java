class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        

        for(int i = 0 ; i < n ; i++){
            if(i == n-1) ans[n-1] = -1;
            int a = -1;
            for(int j = i + 1 ; j < n ; j++){
                a = Math.max( a , arr[j]);    
            }
            ans[i] = a;
        }
        return ans;
        
    }
}