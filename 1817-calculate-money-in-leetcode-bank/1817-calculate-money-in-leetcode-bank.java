class Solution {
    public int totalMoney(int n) {
        int w = n / 7;
        int d = n % 7;
        int ttl = 0;
        for(int i = 0 ; i < w ; i++){
            ttl += (7*(i+1)) + (6*7) / 2;
        }
        int s = w + 1;
        for(int i = 0 ; i < d ; i++){
            ttl += s + i;
        }
        return ttl;
    }
}