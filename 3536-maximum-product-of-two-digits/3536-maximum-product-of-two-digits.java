class Solution {
    public int maxProduct(int n) {
        int[] arr = new int[10];
        int i = 0;
        while(n > 0){
            int num = n % 10;
            arr[i] = num;
            i++;
            n /= 10;
        }
        int max = 0;
        for(int z = 0; z < 9; z++){
            for(int j = z + 1; j < 10; j++){
                max = Math.max(max, arr[z] * arr[j]);
            }
        }
        return max;
    }
}