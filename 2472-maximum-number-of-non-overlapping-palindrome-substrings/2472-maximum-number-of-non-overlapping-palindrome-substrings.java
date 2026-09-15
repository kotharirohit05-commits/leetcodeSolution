class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        int ans = 0;
        int lastEnd = -1; // Tracks the end index of the last chosen palindrome
        
        for (int i = 0; i < n; i++) {
            // 1. Check for odd-length palindromes centered at i
            int l1 = i, r1 = i;
            while (l1 >= 0 && r1 < n && s.charAt(l1) == s.charAt(r1)) {
                int length = r1 - l1 + 1;
                if (length >= k && l1 > lastEnd) {
                    ans++;
                    lastEnd = r1;
                    break; // Greedily pick the earliest ending palindrome
                }
                if (length > k + 1) {
                    break; // No need to look for longer ones
                }
                l1--;
                r1++;
            }
            
            // 2. Check for even-length palindromes centered between i and i+1
            int l2 = i, r2 = i + 1;
            while (l2 >= 0 && r2 < n && s.charAt(l2) == s.charAt(r2)) {
                int length = r2 - l2 + 1;
                if (length >= k && l2 > lastEnd) {
                    ans++;
                    lastEnd = r2;
                    break;
                }
                if (length > k + 1) {
                    break;
                }
                l2--;
                r2++;
            }
        }
        
        return ans;
    }
}
