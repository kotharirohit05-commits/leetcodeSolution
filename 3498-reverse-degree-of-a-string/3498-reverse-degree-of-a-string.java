class Solution {
    public int reverseDegree(String s) {
        int[] arr = new int[s.length()];
        int p = 0;
        for(int i  = 0 ; i < s.length() ; i++){
            int c = 'z' - s.charAt(i) + 1;
            int asc = (int) c;
            arr[p++] = asc;
        }
        int count = 1;
        int sum = 0;
        for(int i = 0 ; i < arr.length ; i++){
            sum += arr[i] * count;
            count++;
        }
        return sum;
    }
}