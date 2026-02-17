class Solution {
    public int xorOperation(int n, int start) {
        int[] arr = new int[n];
        int count = n;
        int k = 0;
        while(count > 0){
            arr[k] = start;
            k++;
            start += 2;
            count--;
        }
        int xor = 0;
        for(int i = 0 ; i < arr.length ; i++){
            xor = xor ^ arr[i];
        }
        return xor;
    }
}