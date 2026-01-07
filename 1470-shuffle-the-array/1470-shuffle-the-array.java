class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] arr = new int[nums.length];
        int idx=0;
        for(int i = 0 ; i < nums.length / 2 ; i++){
            arr[idx++] = nums[i];
            arr[idx++] = nums[n+i];
        }
        return arr;
    }
}