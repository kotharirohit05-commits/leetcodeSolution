class Solution {
    public long flowerGame(int n, int m) {
        long ofn = (n+1)/2;
        long efn = (n/2);
        long ofm = (m+1)/2;
        long efm = (m/2);
        long ttl = (ofn * efm) + (efn * ofm);
        return ttl;

    }
}