import java.util.List;

class Solution {
    public int maxSum(List<Integer> nums, int k) {
        long MOD = 1_000_000_007L;
        int[] bitCounts = new int[32];
        
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if (((num >> i) & 1) == 1) {
                    bitCounts[i]++;
                }
            }
        }
        
        long totalSumSquares = 0;
        
        
        for (int j = 0; j < k; j++) {
            long currentNum = 0;
            for (int i = 0; i < 32; i++) {
                if (bitCounts[i] > 0) {
                    currentNum |= (1L << i);
                    bitCounts[i]--;          
                }
            }
            
            long square = (currentNum * currentNum) % MOD;
            totalSumSquares = (totalSumSquares + square) % MOD;
        }
        
        return (int) totalSumSquares;
    }
}
