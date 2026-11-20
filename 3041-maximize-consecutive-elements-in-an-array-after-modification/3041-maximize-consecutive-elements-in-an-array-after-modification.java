import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxSelectedElements(int[] nums) {
        // Sort the array to process elements in non-decreasing order
        Arrays.sort(nums);
        
        // dp.get(v) stores the max length of a consecutive sequence ending at v
        Map<Integer, Integer> dp = new HashMap<>();
        int maxLen = 0;
        
        for (int x : nums) {
            // Option 1: Increase x to x + 1 (update first so we don't reuse the same x)
            int lenPlusOne = dp.getOrDefault(x, 0) + 1;
            dp.put(x + 1, lenPlusOne);
            
            // Option 2: Keep x as x
            int lenSame = dp.getOrDefault(x - 1, 0) + 1;
            dp.put(x, lenSame);
            
            // Update the global maximum length
            maxLen = Math.max(maxLen, Math.max(lenSame, lenPlusOne));
        }
        
        return maxLen;
    }
}
