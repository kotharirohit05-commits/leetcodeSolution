import java.util.*;

class Solution {
    public List<Integer> maxPrimes(int n, int s) {

        List<Integer> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();

        if (n < 2 || s < 2) {
            return res; 
        }

        // MINIMAL CHANGE: Replaced individual isPrime loop with a Boolean array filter (Sieve)
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        
        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        // Collect the calculated primes into your original 'ans' list
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                ans.add(i);
            }
        }
        
        int currsum = 0;

        for(int i = 0; i < ans.size(); i++){
            if((currsum + ans.get(i)) <= s){
                currsum += ans.get(i);
                res.add(ans.get(i));
            }else{
                break;
            }
        }

        return res;
    }
    // Note: The private isPrime(int x) helper method is no longer needed and can be safely deleted.
}
