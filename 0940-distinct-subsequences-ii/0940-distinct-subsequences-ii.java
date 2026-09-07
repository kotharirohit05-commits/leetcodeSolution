import java.util.Arrays;

class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        
        // endWith[i] stores the number of distinct subsequences 
        // that end with the i-th character ('a' -> 0, 'b' -> 1, etc.)
        long[] endWith = new long[26];
        
        for (int i = 0; i < s.length(); i++) {
            int charIdx = s.charAt(i) - 'a';
            
            // Sum up all existing distinct subsequences
            long currentSum = 0;
            for (long count : endWith) {
                currentSum = (currentSum + count) % MOD;
            }
            
            // The new subsequences formed by appending s[i] to all current ones,
            // plus the character s[i] itself as a single-letter subsequence (+1)
            endWith[charIdx] = (currentSum + 1) % MOD;
        }
        
        // Sum up the total counts from all 26 ending buckets
        long totalSubsequences = 0;
        for (long count : endWith) {
            totalSubsequences = (totalSubsequences + count) % MOD;
        }
        
        return (int) totalSubsequences;
    }
}
