import java.util.Arrays;

class Solution {
    public boolean uniformArray(int[] nums1) {
        int minOdd = Integer.MAX_VALUE;
        int minEven = Integer.MAX_VALUE;
        
        for (int num : nums1) {
            if (num % 2 == 0) {
                if (num < minEven) {
                    minEven = num;
                }
            } else {
                if (num < minOdd) {
                    minOdd = num;
                }
            }
        }
        
        // If the array contains only even or only odd numbers, it's already uniform
        if (minOdd == Integer.MAX_VALUE || minEven == Integer.MAX_VALUE) {
            return true;
        }
        
        // Every even element must be larger than the smallest odd element to become odd
        return minEven > minOdd;
    }
}
