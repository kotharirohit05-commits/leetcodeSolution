class Solution {
    public int[] replaceElements(int[] arr) {
        int max = -1;
        int n = arr.length;
        for(int i = n - 1 ; i >= 0 ; i--){
            int curr = arr[i];
            arr[i] = max;
            if(curr > max){
                max = curr;
            }
        }
        return arr;
    }
}