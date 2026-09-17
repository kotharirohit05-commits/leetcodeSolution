import java.util.Arrays;

class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        
        // minLen[i] stores the minimum length of a valid sub-array ending at or before index i
        int[] minLen = new int[n];
        Arrays.fill(minLen, Integer.MAX_VALUE);
        
        int left = 0;
        int currentSum = 0;
        int minTotalLength = Integer.MAX_VALUE;
        int bestSoFar = Integer.MAX_VALUE; // Tracks the smallest valid sub-array length seen so far
        
        for (int right = 0; right < n; right++) {
            currentSum += arr[right];
            
            // Shrink the window from the left if the sum exceeds the target
            while (currentSum > target && left <= right) {
                currentSum -= arr[left];
                left++;
            }
            
            // If we found a valid sub-array with the target sum
            if (currentSum == target) {
                int currentLen = right - left + 1;
                
                // Check if there is a valid, non-overlapping sub-array to the left of our current window
                if (left > 0 && minLen[left - 1] != Integer.MAX_VALUE) {
                    minTotalLength = Math.min(minTotalLength, currentLen + minLen[left - 1]);
                }
                
                // Update the smallest valid sub-array length seen up to the current index
                bestSoFar = Math.min(bestSoFar, currentLen);
            }
            
            // Record the best sub-array length seen so far for the prefix ending at 'right'
            minLen[right] = bestSoFar;
        }
        
        return minTotalLength == Integer.MAX_VALUE ? -1 : minTotalLength;
    }
}
