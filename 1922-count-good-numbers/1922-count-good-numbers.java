class Solution {
    private int MOD = 1000000007;
    private long power(int x, long n){
        if(n == 0) return 1;
        long half = power( x, n / 2);
        if( n % 2 == 0){
            return (half * half) % MOD;
        }else {
            return (((half * half) % MOD) * x ) % MOD;
        }
    }
    public int countGoodNumbers(long n) {
        long ecount = (n + 1) / 2;
        long ocount = n / 2;

        long eways = power(5, ecount);
        long oways = power(4, ocount);

        return (int)((eways * oways) % MOD);
    }
}