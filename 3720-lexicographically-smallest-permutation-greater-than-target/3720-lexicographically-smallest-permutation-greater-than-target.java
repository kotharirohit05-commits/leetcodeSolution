import java.util.Arrays;

class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] counts = new int[26];
        for (int i = 0; i < n; i++) {
            counts[s.charAt(i) - 'a']++;
        }

        // Track how far we can successfully match the target prefix
        boolean[] canMatchPrefix = new boolean[n + 1];
        canMatchPrefix[0] = true;

        int[] prefixCounts = new int[26];
        for (int i = 0; i < n; i++) {
            int charIdx = target.charAt(i) - 'a';
            if (prefixCounts[charIdx] < counts[charIdx]) {
                prefixCounts[charIdx]++;
                canMatchPrefix[i + 1] = true;
            } else {
                break;
            }
        }

        // Search from right to left for the first valid position to diverge
        for (int i = n - 1; i >= 0; i--) {
            if (!canMatchPrefix[i]) {
                continue;
            }

            // Reconstruct the remaining pool of characters for target[0...i-1]
            int[] remCounts = counts.clone();
            for (int j = 0; j < i; j++) {
                remCounts[target.charAt(j) - 'a']--;
            }

            // Find the smallest character strictly greater than target.charAt(i)
            int targetCharIdx = target.charAt(i) - 'a';
            int chosenCharIdx = -1;
            for (int c = targetCharIdx + 1; c < 26; c++) {
                if (remCounts[c] > 0) {
                    chosenCharIdx = c;
                    break;
                }
            }

            // If a valid higher character exists, build the optimal string
            if (chosenCharIdx != -1) {
                StringBuilder sb = new StringBuilder();
                
                // 1. Add the matching prefix
                sb.append(target, 0, i);
                
                // 2. Add the next greater character
                sb.append((char) ('a' + chosenCharIdx));
                remCounts[chosenCharIdx]--;

                // 3. Fill the rest greedily with the smallest available characters
                for (int c = 0; c < 26; c++) {
                    while (remCounts[c] > 0) {
                        sb.append((char) ('a' + c));
                        remCounts[c]--;
                    }
                }
                return sb.toString();
            }
        }

        return "";
    }
}
