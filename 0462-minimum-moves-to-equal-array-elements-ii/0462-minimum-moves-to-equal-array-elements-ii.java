class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        
        int median = nums[nums.length / 2];
        
        int totalMoves = 0;
        for (int num : nums) {
            totalMoves += Math.abs(num - median);
        }
        
        return totalMoves;
    }
}