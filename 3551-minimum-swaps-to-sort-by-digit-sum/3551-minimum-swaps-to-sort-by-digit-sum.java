import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        
        // 1. Box the primitive int[] array into an Integer[] array so we can use a custom sort
        Integer[] sorted = new Integer[n];
        for (int i = 0; i < n; i++) {
            sorted[i] = nums[i];
        }
        
        // 2. Sort the array using the problem's rules
        Arrays.sort(sorted, (a, b) -> {
            int sumA = getDigitSum(a);
            int sumB = getDigitSum(b);
            if (sumA != sumB) {
                return Integer.compare(sumA, sumB); // Sort by digit sum
            }
            return Integer.compare(a, b);           // Tie-breaker: sort by value
        });
        
        // 3. Map each number to its target/correct index after sorting
        HashMap<Integer, Integer> targetPos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            targetPos.put(sorted[i], i);
        }
        
        // 4. Actively swap elements into their correct positions
        int swaps = 0;
        int i = 0;
        while (i < n) {
            int correctIndex = targetPos.get(nums[i]);
            
            // If the current number is not at its correct sorted index, swap it!
            if (correctIndex != i) {
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
                swaps++; // Increment swap counter
                // Do not increment i because we need to check the newly swapped element
            } else {
                i++; // Element is in the right place, move to the next index
            }
        }
        
        return swaps;
    }
    
    // Easy helper to find sum of digits
    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
