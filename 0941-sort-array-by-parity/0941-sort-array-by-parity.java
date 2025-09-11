class Solution {
    public int[] sortArrayByParity(int[] arr) {
        int l = 0 ;
        int r = arr.length - 1;
        while(l<r){
            if(arr[l] %2 == 0) l++;
            else if(arr[r] %2 != 0) r--;
            else{
                int temp = arr[r];
                arr[r] = arr[l] ; 
                arr[l] = temp;
                l++;
                r--;
            }
        }
        return arr;
    }
}