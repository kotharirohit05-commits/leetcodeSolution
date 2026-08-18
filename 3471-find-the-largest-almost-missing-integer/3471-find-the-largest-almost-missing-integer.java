import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;

        // Case 1: k equals the length of the array
        // There is only 1 subarray, so every unique number appears exactly once.
        if (k == n) {
            int maxVal = -1;
            for (int num : nums) {
                maxVal = Math.max(maxVal, num);
            }
            return maxVal;
        }

        // Case 2: k equals 1
        // Subarrays are single elements. An element is valid if its overall frequency is 1.
        if (k == 1) {
            Map<Integer, Integer> counts = new HashMap<>();
            for (int num : nums) {
                counts.put(num, counts.getOrDefault(num, 0) + 1);
            }
            int maxVal = -1;
            for (int num : counts.keySet()) {
                if (counts.get(num) == 1) {
                    maxVal = Math.max(maxVal, num);
                }
            }
            return maxVal;
        }

        // Case 3: 1 < k < n
        // Only the first and last elements can appear in exactly one subarray of size k.
        // Elements in the middle will always be shared by at least two subarrays.
        int first = nums[0];
        int last = nums[n - 1];
        
        int firstCount = 0;
        int lastCount = 0;
        
        for (int num : nums) {
            if (num == first) firstCount++;
            if (num == last) lastCount++;
        }

        int maxVal = -1;
        // If the first element appears only once in the entire array, it's a candidate
        if (firstCount == 1) {
            maxVal = Math.max(maxVal, first);
        }
        // If the last element appears only once in the entire array, it's a candidate
        if (lastCount == 1) {
            maxVal = Math.max(maxVal, last);
        }

        return maxVal;
    }
}
