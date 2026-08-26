class Solution {
    public String shortestBeautifulSubstring(String s, int k) {

        int n = s.length();
        int left = 0;
        int ones = 0;

        int bestLen = Integer.MAX_VALUE;
        int bestStart = -1;

        for (int right = 0; right < n; right++) {

            if (s.charAt(right) == '1') {
                ones++;
            }

            while (ones > k) {
                if (s.charAt(left) == '1') {
                    ones--;
                }
                left++;
            }

            if (ones == k) {

                while (s.charAt(left) == '0') {
                    left++;
                }

                int len = right - left + 1;

                if (len < bestLen) {
                    bestLen = len;
                    bestStart = left;
                } 
                else if (len == bestLen) {

                    // Compare current candidate with best candidate
                    String curr = s.substring(left, right + 1);
                    String best = s.substring(bestStart, bestStart + bestLen);

                    if (curr.compareTo(best) < 0) {
                        bestStart = left;
                    }
                }
            }
        }

        return bestStart == -1
                ? ""
                : s.substring(bestStart, bestStart + bestLen);
    }
}