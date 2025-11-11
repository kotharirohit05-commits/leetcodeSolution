class Solution {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] ans = new int[n];

        
        int lastPos = -10000; 
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                lastPos = i;
            }
            ans[i] = i - lastPos;
        }

        
        lastPos = 10000; 
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                lastPos = i;
            }
            ans[i] = Math.min(ans[i], lastPos - i);
        }

        return ans;
    }
}
