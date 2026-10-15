class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int totalSumOfSquares = 0;

        // Outer loop: fixed starting position of the subarray
        for (int i = 0; i < n; i++) {
            HashSet<Integer> distinctElements = new HashSet<>();

            // Inner loop: incrementally expand the subarray to the right
            for (int j = i; j < n; j++) {
                // O(1) average time to add element and update distinct count
                distinctElements.add(nums.get(j));
                
                int distinctCount = distinctElements.size();
                
                // Add the square of the distinct elements to the total sum
                totalSumOfSquares += distinctCount * distinctCount;
            }
        }

        return totalSumOfSquares;
    }
}
