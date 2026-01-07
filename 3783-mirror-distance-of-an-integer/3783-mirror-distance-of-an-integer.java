class Solution {
    public int mirrorDistance(int n) {
        if(n < 10) return 0;
        int rev = 0 ;
        int temp = n;
        while(n > 0){
            int dig = n % 10;
            rev = rev * 10 + dig;
            n /= 10;
        }


        return Math.abs(rev - temp);
    }
}