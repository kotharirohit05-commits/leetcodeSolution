class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        if(arr.length < 3) return true;
        int[] ans = new int[arr.length];
        Arrays.sort(arr);
        int l = 0;

        for(int i = 1 ; i < arr.length ; i++){
            ans[l] = arr[i] - arr[i-1];
            l++;
        }
 
        boolean isap = true;
        for(int i = 0 ; i < arr.length - 2 ; i++){
            if(ans[i] != ans[i+1]){
                isap = false;
                break;
            }
        }
        return isap;
       
        
    }
}