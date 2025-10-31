class Solution {
    public int arrangeCoins(int n) {
        int left = 1;
        int count = 0;
        while(n >= left){
            n -= left;
            left++;
            count++;
        }
        return count ;
    }
}