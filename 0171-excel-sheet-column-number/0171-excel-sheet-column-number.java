class Solution {
    public int titleToNumber(String col) {
        int p = 0 ; 
        int sum = 0 ;
        int n = col.length();
        for(int i = n-1 ; i >=0; i--){
            int temp = col.charAt(i) - 64;
            sum = sum + (int)Math.pow(26 , p++)*temp;
        }
        return sum;

    }
}