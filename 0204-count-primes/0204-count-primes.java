class Solution {
    public int countPrimes(int n) {
        if(n <= 2) return 0;
        int count = 0;
        boolean[] isPrime = new boolean[n];
        for(int i = 2 ; i < n ; i++){
            isPrime[i] = true;
        }
        for(int i = 2 ; i < n ; i++){
            if(isPrime[i]){
                count++;
                for(int j = 2*i ; j < n ; j = j + i){
                    isPrime[j] = false;
                }
            }
        }
        return count;
    }
}