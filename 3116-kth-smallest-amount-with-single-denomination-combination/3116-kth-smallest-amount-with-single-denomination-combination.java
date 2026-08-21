import java.util.Arrays;

class Solution {
    public long findKthSmallest(int[] coins, int k) {
        int n = coins.length;
        int numSubsets = (1 << n) - 1;
        
        // Cache subset information to maximize performance during binary search
        long[] lcmValues = new long[numSubsets];
        long[] signs = new long[numSubsets];
        int idx = 0;
        
        // Precompute LCMs and signs (+1 or -1) for all 2^N - 1 subsets
        for (int mask = 1; mask < (1 << n); mask++) {
            int bits = 0;
            long currLcm = 1;
            
            for (int i = 0; i < n; i++) {
                if (((mask >> i) & 1) == 1) {
                    bits++;
                    currLcm = lcm(currLcm, coins[i]);
                }
            }
            
            lcmValues[idx] = currLcm;
            signs[idx] = (bits % 2 == 1) ? 1 : -1;
            idx++;
        }
        
        // Establish Binary Search boundary
        long low = 1;
        long high = Long.MAX_VALUE;
        for (int coin : coins) {
            high = Math.min(high, (long) coin * k);
        }
        
        long ans = high;
        
        // Binary search on the resulting value space
        while (low <= high) {
            long mid = low + (high - low) / 2;
            
            if (countLessEqual(mid, lcmValues, signs) >= k) {
                ans = mid;
                high = mid - 1; // Try to search for a smaller valid amount
            } else {
                low = mid + 1;  // Current value too small, push the lower boundary up
            }
        }
        
        return ans;
    }
    
    // Uses the Inclusion-Exclusion Principle (IEP) to count multiples <= x
    private long countLessEqual(long x, long[] lcmValues, long[] signs) {
        long total = 0;
        for (int i = 0; i < lcmValues.length; i++) {
            total += signs[i] * (x / lcmValues[i]);
        }
        return total;
    }
    
    // Calculates Greatest Common Divisor (GCD)
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    // Calculates Least Common Multiple (LCM)
    private long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
}
