class Solution {
    public int sumOfGoodIntegers(int n, int k) {
        int x = 1;
        int count = 0;
        while(x <= (n + k)){
            if((Math.abs(n - x) <= k) && ((n & x) == 0)){
                count += x;
                
            }
            x++;
            
        }
        return count;
    }
}