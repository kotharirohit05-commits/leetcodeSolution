class Solution {
    public int minimumSwaps(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int count = 0;
        
        while(start < end){
            while(start < end && nums[start] != 0){
                start++;
            }
            while(end > start && nums[end] == 0){
                end--;
            }
            if(start < end){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                count++;
                start++;
                end--;
            }
        }
        
        return count;
    }
}