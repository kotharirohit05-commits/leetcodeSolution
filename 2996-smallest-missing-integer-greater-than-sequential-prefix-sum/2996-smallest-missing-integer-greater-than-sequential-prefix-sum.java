import java.util.HashSet;
import java.util.Set;

class Solution {
    public int missingInteger(int[] nums) {
        // 1. Find the sum of the longest sequential prefix
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
            } else {
                break; // Break as soon as the sequence is broken
            }
        }
        
        // 2. Add all numbers to a hash set for O(1) lookups
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        
        // 3. Find the smallest missing integer >= sum
        while (numSet.contains(sum)) {
            sum++;
        }
        
        return sum;
    }
}
