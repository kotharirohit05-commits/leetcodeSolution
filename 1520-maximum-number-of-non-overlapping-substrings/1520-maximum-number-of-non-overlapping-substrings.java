import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        
        // Initialize arrays with -1 to indicate character hasn't appeared yet
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);
        
        // Step 1: Find the first and last occurrence of each character
        for (int i = 0; i < n; i++) {
            int charIdx = s.charAt(i) - 'a';
            if (first[charIdx] == -1) {
                first[charIdx] = i;
            }
            last[charIdx] = i;
        }
        
        List<int[]> validIntervals = new ArrayList<>();
        
        // Step 2: Expand intervals for each unique character
        for (int i = 0; i < 26; i++) {
            if (first[i] == -1) continue;
            
            int start = first[i];
            int end = last[i];
            boolean isValid = true;
            
            for (int j = start; j <= end; j++) {
                int charIdx = s.charAt(j) - 'a';
                
                start = Math.min(start, first[charIdx]);
                end = Math.max(end, last[charIdx]);
                
                // If the interval expands to the left of our original starting point,
                // it is invalid for this character (will be covered by the earlier one).
                if (start < first[i]) {
                    isValid = false;
                    break;
                }
            }
            
            if (isValid) {
                validIntervals.add(new int[]{start, end});
            }
        }
        
        // Step 3: Greedy selection
        // Sort intervals primarily by their end index
        validIntervals.sort((a, b) -> Integer.compare(a[1], b[1]));
        
        List<String> res = new ArrayList<>();
        int prevEnd = -1;
        
        for (int[] interval : validIntervals) {
            int start = interval[0];
            int end = interval[1];
            
            if (start > prevEnd) {
                res.add(s.substring(start, end + 1));
                prevEnd = end;
            }
        }
        
        return res;
    }
}
